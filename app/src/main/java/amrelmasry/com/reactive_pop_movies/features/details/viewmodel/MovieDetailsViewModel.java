package amrelmasry.com.reactive_pop_movies.features.details.viewmodel;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import amrelmasry.com.reactive_pop_movies.common.models.Movie;
import amrelmasry.com.reactive_pop_movies.common.models.environments.ViewModelEnvironment;
import amrelmasry.com.reactive_pop_movies.common.viewmodel.BaseViewModel;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Created by Amr on 25/02/17.
 */

public class MovieDetailsViewModel
        extends BaseViewModel<MovieDetailsInputs, MovieDetailsOutputs>
        implements MovieDetailsOutputs, MovieDetailsInputs {

    private final BehaviorSubject<Integer> moviesIdsStream = BehaviorSubject.create();

    @Inject
    public MovieDetailsViewModel(ViewModelEnvironment viewModelEnvironment) {
        super(viewModelEnvironment);
    }


    @Override
    public void loadMovieDetails(int movieId) {
        moviesIdsStream.onNext(movieId);
    }

    @Override
    public Observable<Movie> onMoviesLoaded() {
        return moviesIdsStream.flatMap(movieId -> getDataManager().getMovieDetails(movieId));
    }

    @NonNull
    @Override
    protected MovieDetailsInputs initInputs() {
        return this;
    }

    @NonNull
    @Override
    protected MovieDetailsOutputs initOutputs() {
        return this;
    }


}
