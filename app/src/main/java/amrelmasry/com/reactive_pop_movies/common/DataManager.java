package amrelmasry.com.reactive_pop_movies.common;

import android.support.annotation.Nullable;

import javax.inject.Inject;

import amrelmasry.com.core.BaseDataManager;
import amrelmasry.com.core.models.PaginatedResponse;
import amrelmasry.com.reactive_pop_movies.common.models.Movie;
import rx.Observable;

/**
 * Created by Amr on 19/02/17.
 */

public class DataManager extends BaseDataManager<ApiService> {

    @Inject
    public DataManager(ApiService mApiService) {
        super(mApiService);
    }

    public Observable<PaginatedResponse<Movie>> getPopularMovies(@Nullable Integer page) {
        return mApiService.listPopularMovies(page);
    }
}
