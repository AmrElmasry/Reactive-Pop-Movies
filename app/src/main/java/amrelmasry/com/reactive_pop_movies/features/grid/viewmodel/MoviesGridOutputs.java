package amrelmasry.com.reactive_pop_movies.features.grid.viewmodel;

import java.util.List;

import amrelmasry.com.core.viewmodel.BaseCoreOutputs;
import amrelmasry.com.reactive_pop_movies.common.models.Movie;
import rx.Observable;

/**
 * Created by Amr on 11/02/17.
 */
public interface MoviesGridOutputs extends BaseCoreOutputs {

    Observable<List<Movie>> moviesLoaded();
}
