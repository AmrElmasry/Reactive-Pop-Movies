package amrelmasry.com.reactive_pop_movies.common.models.environments;

import amrelmasry.com.core.models.environments.BaseCoreViewModelEnvironment;
import amrelmasry.com.reactive_pop_movies.common.DataManager;

/**
 * Created by Amr on 19/02/17.
 */

public class ViewModelEnvironment extends BaseCoreViewModelEnvironment<DataManager> {
    public ViewModelEnvironment(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public DataManager getDataManager() {
        return super.getDataManager();
    }
}
