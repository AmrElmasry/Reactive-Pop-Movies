package amrelmasry.com.reactive_pop_movies.base.models;

import com.google.auto.value.AutoValue;

import amrelmasry.com.reactive_pop_movies.base.ApiService;

/**
 * Created by Amr on 03/02/17.
 */

@AutoValue
public abstract class ViewModelEnvironment {

    public static Builder builder() {
        return new AutoValue_ViewModelEnvironment.Builder();
    }

    public abstract ApiService apiService();

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder apiService(ApiService apiService);

        public abstract ViewModelEnvironment build();
    }
}
