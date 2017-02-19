package amrelmasry.com.core;

import amrelmasry.com.core.utils.general.ClassUtils;

/**
 * Created by Amr on 11/02/17.
 */

public abstract class BaseDataManager<T> {

    protected final String LOG_TAG = ClassUtils.generateClassTag(this);

    protected T mApiService;

    public BaseDataManager(T apiService) {
        this.mApiService = apiService;
    }

}
