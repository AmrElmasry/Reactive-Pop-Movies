package amrelmasry.com.core.models.environments;

import amrelmasry.com.core.BaseDataManager;
import amrelmasry.com.core.utils.general.ClassUtils;

/**
 * Created by Amr on 03/02/17.
 */

public abstract class BaseCoreViewModelEnvironment<M extends BaseDataManager> {

    protected final String LOG_TAG = ClassUtils.generateClassTag(this);

    private M dataManager;

    public BaseCoreViewModelEnvironment(M dataManager) {
        this.dataManager = dataManager;
    }

    public M getDataManager() {
        return dataManager;
    }

    public void setDataManager(M dataManager) {
        this.dataManager = dataManager;
    }
}

