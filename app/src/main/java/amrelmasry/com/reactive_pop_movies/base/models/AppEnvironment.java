package amrelmasry.com.reactive_pop_movies.base.models;

import android.app.Application;
import android.content.SharedPreferences;

import com.google.auto.value.AutoValue;

/**
 * Created by Amr on 03/02/17.
 */

@AutoValue
public abstract class AppEnvironment {

    public static Builder builder() {
        return new AutoValue_AppEnvironment.Builder();
    }

    public abstract Application application();

    public abstract SharedPreferences sharedPreferences();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder application(Application application);

        public abstract Builder sharedPreferences(SharedPreferences sharedPreferences);


        public abstract AppEnvironment build();

    }
}
