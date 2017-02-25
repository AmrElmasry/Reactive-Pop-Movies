package amrelmasry.com.core.activity;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import amrelmasry.com.core.BaseApp;
import amrelmasry.com.core.models.environments.BaseCoreAppEnvironment;
import amrelmasry.com.core.utils.general.ClassUtils;
import butterknife.ButterKnife;

/**
 * Created by Amr on 03/02/17.
 */

public abstract class BaseCoreActivity extends AppCompatActivity {

    protected final String LOG_TAG = ClassUtils.generateClassTag(this);

    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initActivityLayout());
        injectDependencies();
        ButterKnife.bind(this);
    }

    @LayoutRes
    protected abstract int initActivityLayout();

    protected abstract void injectDependencies();

    protected abstract BaseApp getApp();

    public abstract BaseCoreAppEnvironment getAppEnvironment();

    protected void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
