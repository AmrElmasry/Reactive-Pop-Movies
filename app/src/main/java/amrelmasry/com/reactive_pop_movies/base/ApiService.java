package amrelmasry.com.reactive_pop_movies.base;

import android.support.annotation.Nullable;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Amr on 03/02/17.
 */

public interface ApiService {

    @GET("/movie/popular")
    Observable<Response> listPopularMovies(@Query("page") @Nullable Integer page);

    @GET("/movie/top_rated")
    Observable<Response> listTopRatedMovies(@Query("page") @Nullable Integer page);
}
