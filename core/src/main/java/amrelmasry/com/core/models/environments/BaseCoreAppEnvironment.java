package amrelmasry.com.core.models.environments;

import android.app.Application;
import android.content.SharedPreferences;

import amrelmasry.com.core.utils.general.ClassUtils;

/**
 * Created by Amr on 03/02/17.
 */

public abstract class BaseCoreAppEnvironment {

    protected final String LOG_TAG = ClassUtils.generateClassTag(this);

    private Application application;

    private SharedPreferences sharedPreferences;


    public BaseCoreAppEnvironment(Application application, SharedPreferences sharedPreferences) {
        this.application = application;
        this.sharedPreferences = sharedPreferences;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }
}
