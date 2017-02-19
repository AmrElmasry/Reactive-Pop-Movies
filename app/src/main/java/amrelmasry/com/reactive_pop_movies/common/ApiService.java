package amrelmasry.com.reactive_pop_movies.common;

import android.support.annotation.Nullable;

import amrelmasry.com.core.models.PaginatedResponse;
import amrelmasry.com.reactive_pop_movies.common.models.Movie;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Amr on 03/02/17.
 */

public interface ApiService {

    @GET("/3/movie/popular")
    Observable<PaginatedResponse<Movie>> listPopularMovies(@Query("page") @Nullable Integer page);

    @GET("/3/movie/top_rated")
    Observable<PaginatedResponse<Movie>> listTopRatedMovies(@Query("page") @Nullable Integer page);
}
