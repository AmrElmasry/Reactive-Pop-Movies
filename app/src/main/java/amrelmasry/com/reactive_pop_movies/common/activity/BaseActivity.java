package amrelmasry.com.reactive_pop_movies.common.activity;

import javax.inject.Inject;

import amrelmasry.com.core.activity.BaseCoreActivity;
import amrelmasry.com.reactive_pop_movies.App;
import amrelmasry.com.reactive_pop_movies.common.models.environments.AppEnvironment;

/**
 * Created by Amr on 19/02/17.
 */

public abstract class BaseActivity extends BaseCoreActivity {


    @Inject
    AppEnvironment mAppEnvironment;

    @Override
    protected App getApp() {
        return (App) getApplication();
    }

    @Override
    public AppEnvironment getAppEnvironment() {
        return mAppEnvironment;
    }
}
