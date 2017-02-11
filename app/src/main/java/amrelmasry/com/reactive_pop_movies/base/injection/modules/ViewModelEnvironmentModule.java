package amrelmasry.com.reactive_pop_movies.base.injection.modules;

import javax.inject.Singleton;

import amrelmasry.com.reactive_pop_movies.base.ApiService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Amr on 03/02/17.
 */

@Module
public class ViewModelEnvironmentModule {

    @Singleton
    @Provides
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
