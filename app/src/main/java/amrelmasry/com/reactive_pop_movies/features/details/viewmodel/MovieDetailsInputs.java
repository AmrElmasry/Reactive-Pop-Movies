package amrelmasry.com.reactive_pop_movies.features.details.viewmodel;

import amrelmasry.com.core.viewmodel.BaseCoreInputs;
import amrelmasry.com.reactive_pop_movies.common.models.Movie;

/**
 * Created by Amr on 25/02/17.
 */
public interface MovieDetailsInputs extends BaseCoreInputs {
    void loadMovieDetails(int movieId);

    void addToFavorites(final Movie movie);

    void removeFromFavorites(final Movie movie);
}
