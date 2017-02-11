package amrelmasry.com.reactive_pop_movies.base.injection.components.base;

import javax.inject.Singleton;

import amrelmasry.com.reactive_pop_movies.base.activity.BaseActivity;
import amrelmasry.com.reactive_pop_movies.base.injection.modules.AppEnvironmentModule;
import amrelmasry.com.reactive_pop_movies.base.injection.modules.ViewModelEnvironmentModule;
import amrelmasry.com.reactive_pop_movies.base.injection.modules.base.AppModule;
import amrelmasry.com.reactive_pop_movies.base.injection.modules.base.NetworkModule;
import dagger.Component;

/**
 * Created by Amr on 03/02/17.
 */
@Singleton
@Component(modules = {AppModule.class,
        NetworkModule.class,
        AppEnvironmentModule.class,
        ViewModelEnvironmentModule.class})
public interface AppComponent {
    void inject(BaseActivity baseActivity);
}
