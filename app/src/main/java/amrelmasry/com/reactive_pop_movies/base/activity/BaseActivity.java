package amrelmasry.com.reactive_pop_movies.base.activity;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import amrelmasry.com.reactive_pop_movies.App;
import amrelmasry.com.reactive_pop_movies.base.models.AppEnvironment;

/**
 * Created by Amr on 03/02/17.
 */

public class BaseActivity extends AppCompatActivity {

    @Inject
    AppEnvironment mAppEnvironment;

    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
    }

    private void injectDependencies() {
        getMyApp().getAppComponent().inject(this);
    }

    public App getMyApp() {
        return (App) getApplication();
    }

    public AppEnvironment getAppEnvironment() {
        return mAppEnvironment;
    }
}
