package amrelmasry.com.reactive_pop_movies;

import amrelmasry.com.core.BaseApp;
import amrelmasry.com.reactive_pop_movies.common.injection.components.base.AppComponent;
import amrelmasry.com.reactive_pop_movies.common.injection.components.base.DaggerAppComponent;
import amrelmasry.com.reactive_pop_movies.common.injection.modules.AppEnvironmentModule;
import amrelmasry.com.reactive_pop_movies.common.injection.modules.ViewModelEnvironmentModule;
import amrelmasry.com.reactive_pop_movies.common.injection.modules.base.AppModule;
import amrelmasry.com.reactive_pop_movies.common.injection.modules.base.NetworkModule;

/**
 * Created by Amr on 03/02/17.
 */

public class App extends BaseApp {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public AppComponent getAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = createAppComponent();
        }
        return mAppComponent;
    }

    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .appEnvironmentModule(new AppEnvironmentModule())
                .networkModule(new NetworkModule())
                .viewModelEnvironmentModule(new ViewModelEnvironmentModule())
                .build();
    }
}
