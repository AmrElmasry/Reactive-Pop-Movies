package amrelmasry.com.reactive_pop_movies.features.grid.viewmodel;

import amrelmasry.com.core.viewmodel.BaseCoreInputs;
import amrelmasry.com.reactive_pop_movies.common.constantgroups.FilteringTypes;

/**
 * Created by Amr on 11/02/17.
 */
public interface MoviesGridInputs extends BaseCoreInputs {

    void loadMoreMovies(@FilteringTypes int filterType);

    void loadMoviesFromScratch(@FilteringTypes int filterType);
}
