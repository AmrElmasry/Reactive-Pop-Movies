package amrelmasry.com.reactive_pop_movies.features.grid.viewmodel;

import amrelmasry.com.reactive_pop_movies.common.constantgroups.FilteringTypes;

/**
 * Created by Amr on 11/02/17.
 */

public class MoviesGridCmds {
    public static class LoadMoviesCmd {

        private int filterType;

        public LoadMoviesCmd(@FilteringTypes int filterType) {

            this.filterType = filterType;
        }

        public int getFilterType() {
            return filterType;
        }
    }
}
