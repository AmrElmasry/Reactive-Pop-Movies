package amrelmasry.com.reactive_pop_movies.features.details.viewmodel;

import amrelmasry.com.core.viewmodel.BaseCoreInputs;

/**
 * Created by Amr on 25/02/17.
 */
public interface MovieDetailsInputs extends BaseCoreInputs {
    void loadMovieDetails(int movieId);
}
