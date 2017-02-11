package amrelmasry.com.reactive_pop_movies.base.injection.modules;

import android.app.Application;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import amrelmasry.com.reactive_pop_movies.base.models.AppEnvironment;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Amr on 03/02/17.
 */

@Module
public class AppEnvironmentModule {

    @Provides
    @Singleton
    AppEnvironment provideAppEnvironment(@NonNull Application application,
                                         @NonNull SharedPreferences sharedPreferences) {
        return AppEnvironment
                .builder()
                .application(application)
                .sharedPreferences(sharedPreferences)
                .build();
    }
}
