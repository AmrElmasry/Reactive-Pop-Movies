package amrelmasry.com.reactive_pop_movies.common;

import android.support.annotation.Nullable;

import java.util.Locale;

import javax.inject.Inject;

import amrelmasry.com.core.BaseDataManager;
import amrelmasry.com.core.models.PaginatedResponse;
import amrelmasry.com.reactive_pop_movies.common.constantgroups.FilteringTypes;
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

    public Observable<PaginatedResponse<Movie>> getMovies(@FilteringTypes Integer filterType,
                                                          @Nullable Integer page) {
        switch (filterType) {
            case FilteringTypes.HIGHEST_RATED_FILTER:
                return mApiService.listTopRatedMovies(page);
            case FilteringTypes.MOST_POPULAR_FILTER:
                return mApiService.listPopularMovies(page);
            default:
                throw new IllegalArgumentException(String.format(Locale.US,
                        "Unsupported Filter Type %d", filterType));
        }
    }

    public Observable<Movie> getMovieDetails(Integer movieId) {
        return mApiService.getMovieDetails(movieId);
    }
}
