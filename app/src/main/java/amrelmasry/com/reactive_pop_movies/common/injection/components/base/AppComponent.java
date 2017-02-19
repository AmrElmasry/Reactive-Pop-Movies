package amrelmasry.com.reactive_pop_movies.common.injection.components.base;

import javax.inject.Singleton;

import amrelmasry.com.reactive_pop_movies.common.injection.modules.AppEnvironmentModule;
import amrelmasry.com.reactive_pop_movies.common.injection.modules.ViewModelEnvironmentModule;
import amrelmasry.com.reactive_pop_movies.common.injection.modules.base.AppModule;
import amrelmasry.com.reactive_pop_movies.common.injection.modules.base.NetworkModule;
import amrelmasry.com.reactive_pop_movies.features.grid.MoviesGridActivity;
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
    void inject(MoviesGridActivity moviesGridActivity);
}
