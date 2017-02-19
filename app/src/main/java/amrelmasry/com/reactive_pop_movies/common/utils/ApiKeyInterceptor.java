package amrelmasry.com.reactive_pop_movies.common.utils;

import java.io.IOException;

import amrelmasry.com.reactive_pop_movies.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Amr on 03/02/17.
 */

public class ApiKeyInterceptor implements Interceptor {
    private static final String API_KEY_PARAMETER = "api_key";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request requestWithTheApiKey = chain.request()
                .newBuilder()
                .url(addApiKeyToRequest(chain.request().url()))
                .build();
        return chain.proceed(requestWithTheApiKey);
    }

    private HttpUrl addApiKeyToRequest(HttpUrl originalRequestUrl) {
        return originalRequestUrl
                .newBuilder()
                .addQueryParameter(API_KEY_PARAMETER, BuildConfig.TMDB_API_KEY)
                .build();
    }
}
