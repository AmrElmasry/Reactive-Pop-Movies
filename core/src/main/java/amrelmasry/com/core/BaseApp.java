package amrelmasry.com.core;

import android.app.Application;

import amrelmasry.com.core.utils.general.ClassUtils;

/**
 * Created by Amr on 19/02/17.
 */

public class BaseApp extends Application {

    protected final String LOG_TAG = ClassUtils.generateClassTag(this);

}
