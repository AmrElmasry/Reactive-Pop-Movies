package amrelmasry.com.reactive_pop_movies.features.grid.viewmodel;

import java.util.List;

import javax.inject.Inject;

import amrelmasry.com.core.models.PaginatedResponse;
import amrelmasry.com.core.utils.Paginator;
import amrelmasry.com.reactive_pop_movies.common.models.Movie;
import amrelmasry.com.reactive_pop_movies.common.models.environments.ViewModelEnvironment;
import amrelmasry.com.reactive_pop_movies.common.viewmodel.BaseViewModel;
import amrelmasry.com.reactive_pop_movies.features.grid.viewmodel.MoviesGridCmds.LoadMoviesCmd;
import rx.Observable;
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

    @Override
    protected MoviesGridInputs initInputs() {
        return this;
    }

    @Override
    protected MoviesGridOutputs initOutputs() {
        return this;
    }

    @Override
    public void loadMovies() {
        loadMoviesCmdSubject.onNext(new LoadMoviesCmd());
    }

    @Override
    public Observable<List<Movie>> moviesLoaded() {
        return loadMoviesCmdSubject.flatMap(__ -> paginator.getNextPage())
                .flatMap(page -> getDataManager().getPopularMovies(page))
                .doOnNext(moviePaginatedResponse -> paginator.processPaginatedResponse(moviePaginatedResponse))
                .map(PaginatedResponse::getResults);
    }
}
