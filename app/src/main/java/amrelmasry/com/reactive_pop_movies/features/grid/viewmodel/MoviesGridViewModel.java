package amrelmasry.com.reactive_pop_movies.features.grid.viewmodel;

import android.support.annotation.NonNull;
import android.support.v4.util.Pair;

import java.util.List;

import javax.inject.Inject;

import amrelmasry.com.core.models.PaginatedResponse;
import amrelmasry.com.core.utils.Paginator;
import amrelmasry.com.reactive_pop_movies.common.constantgroups.FilteringTypes;
import amrelmasry.com.reactive_pop_movies.common.models.Movie;
import amrelmasry.com.reactive_pop_movies.common.models.environments.ViewModelEnvironment;
import amrelmasry.com.reactive_pop_movies.common.viewmodel.BaseViewModel;
import amrelmasry.com.reactive_pop_movies.features.grid.viewmodel.MoviesGridCmds.LoadMoviesCmd;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

/**
 * Created by Amr on 11/02/17.
 */

public class MoviesGridViewModel
        extends BaseViewModel<MoviesGridInputs, MoviesGridOutputs>
        implements MoviesGridInputs, MoviesGridOutputs {

    private BehaviorSubject<LoadMoviesCmd> loadMoviesCmdSubject = BehaviorSubject.create();
    private Paginator paginator = Paginator.create();

    @Inject
    public MoviesGridViewModel(ViewModelEnvironment viewModelEnvironment) {
        super(viewModelEnvironment);
    }

    @NonNull
    @Override
    protected MoviesGridInputs initInputs() {
        return this;
    }

    @NonNull
    @Override
    protected MoviesGridOutputs initOutputs() {
        return this;
    }

    @Override
    public void loadMoreMovies(@FilteringTypes int filterType) {
        loadMoviesCmdSubject.onNext(new LoadMoviesCmd(filterType));
    }

    @Override
    public void loadMoviesFromScratch(@FilteringTypes int filterType) {
        paginator.reset();
        loadMoviesCmdSubject.onNext(new LoadMoviesCmd(filterType));
    }

    @Override
    public Observable<List<Movie>> moviesLoaded() {
        return loadMoviesCmdSubject.map(loadMoviesCmd ->
                (Pair.create(loadMoviesCmd.getFilterType(), paginator.getNextPage())))
                .observeOn(Schedulers.io())
                .flatMap(filterAndPagePair ->
                        getDataManager().getMovies(filterAndPagePair.first, filterAndPagePair.second))
                .doOnNext(moviePaginatedResponse ->
                        paginator.processPaginatedResponse(moviePaginatedResponse))
                .map(PaginatedResponse::getResults);

    }
}
