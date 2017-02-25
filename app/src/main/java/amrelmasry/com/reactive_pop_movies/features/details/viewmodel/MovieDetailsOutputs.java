package amrelmasry.com.reactive_pop_movies.features.details.viewmodel;

import amrelmasry.com.core.viewmodel.BaseCoreOutputs;
import amrelmasry.com.reactive_pop_movies.common.models.Movie;
import rx.Observable;

/**
 * Created by Amr on 25/02/17.
 */
public interface MovieDetailsOutputs extends BaseCoreOutputs {

    Observable<Movie> onMoviesLoaded();
}
