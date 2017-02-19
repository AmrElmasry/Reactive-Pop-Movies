package amrelmasry.com.reactive_pop_movies.common.models.environments;

import android.app.Application;
import android.content.SharedPreferences;

import amrelmasry.com.core.models.environments.BaseCoreAppEnvironment;

/**
 * Created by Amr on 19/02/17.
 */

public class AppEnvironment extends BaseCoreAppEnvironment {
    public AppEnvironment(Application application, SharedPreferences sharedPreferences) {
        super(application, sharedPreferences);
    }
}
