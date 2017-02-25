package amrelmasry.com.reactive_pop_movies.features.grid.rxbus.msgs;

import amrelmasry.com.core.rxbus.msgs.BaseSelectionEvent;
import amrelmasry.com.reactive_pop_movies.common.constantgroups.FilteringTypes;

/**
 * Created by Amr on 25/02/17.
 */

public class FilterSelectionEvent extends BaseSelectionEvent {

    @FilteringTypes
    private int selectedFilter;

    public FilterSelectionEvent(@FilteringTypes int selectedFilter) {
        this.selectedFilter = selectedFilter;
    }

    @FilteringTypes
    public int getSelectedFilter() {
        return selectedFilter;
    }
}
