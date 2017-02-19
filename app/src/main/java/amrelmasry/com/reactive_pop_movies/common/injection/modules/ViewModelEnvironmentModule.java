package amrelmasry.com.reactive_pop_movies.common.injection.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import amrelmasry.com.reactive_pop_movies.common.ApiService;
import amrelmasry.com.reactive_pop_movies.common.DataManager;
import amrelmasry.com.reactive_pop_movies.common.models.environments.ViewModelEnvironment;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Amr on 03/02/17.
 */

@Module
public class ViewModelEnvironmentModule {

    @Provides
    @Singleton
    DataManager provideDataManager(@NonNull ApiService apiService) {
        return new DataManager(apiService);
    }

    @Provides
    @Singleton
    ViewModelEnvironment provideViewModelEnvironment(@NonNull DataManager dataManager) {
        return new ViewModelEnvironment(dataManager);
    }
}
