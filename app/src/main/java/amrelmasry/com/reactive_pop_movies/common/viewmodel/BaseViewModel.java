package amrelmasry.com.reactive_pop_movies.common.viewmodel;

import android.support.annotation.NonNull;

import amrelmasry.com.core.viewmodel.BaseCoreInputs;
import amrelmasry.com.core.viewmodel.BaseCoreOutputs;
import amrelmasry.com.core.viewmodel.BaseCoreViewModel;
import amrelmasry.com.reactive_pop_movies.common.DataManager;
import amrelmasry.com.reactive_pop_movies.common.models.environments.ViewModelEnvironment;

/**
 * Created by Amr on 19/02/17.
 */

public abstract class BaseViewModel<I extends BaseCoreInputs, O extends BaseCoreOutputs>
        extends BaseCoreViewModel<I, O, ViewModelEnvironment> {

    public BaseViewModel(ViewModelEnvironment viewModelEnvironment) {
        super(viewModelEnvironment);
    }

    @NonNull
    @Override
    protected DataManager getDataManager() {
        return getEnvironment().getDataManager();
    }
}
