package amrelmasry.com.reactive_pop_movies;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.util.regex.Pattern;

import amrelmasry.com.core.BaseApp;
import amrelmasry.com.reactive_pop_movies.common.injection.components.base.AppComponent;
import amrelmasry.com.reactive_pop_movies.common.injection.components.base.DaggerAppComponent;
import amrelmasry.com.reactive_pop_movies.common.injection.modules.AppEnvironmentModule;
import amrelmasry.com.reactive_pop_movies.common.injection.modules.ViewModelEnvironmentModule;
import amrelmasry.com.reactive_pop_movies.common.injection.modules.base.AppModule;
import amrelmasry.com.reactive_pop_movies.common.injection.modules.base.NetworkModule;
import io.realm.Realm;

/**
 * Created by Amr on 03/02/17.
 */

public class App extends BaseApp {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        if (BuildConfig.DEBUG) {
            initStetho();
        }
    }

    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());

        RealmInspectorModulesProvider.builder(this)
                .withFolder(getCacheDir())
                .withMetaTables()
                .withDescendingOrder()
                .withLimit(1000)
                .databaseNamePattern(Pattern.compile(".+\\.realm"))
                .build();
    }

    public AppComponent getAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = createAppComponent();
        }
        return mAppComponent;
    }

    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .appEnvironmentModule(new AppEnvironmentModule())
                .networkModule(new NetworkModule())
                .viewModelEnvironmentModule(new ViewModelEnvironmentModule())
                .build();
    }
}
