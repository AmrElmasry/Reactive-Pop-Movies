package amrelmasry.com.core.viewmodel;

import android.support.annotation.NonNull;

import amrelmasry.com.core.BaseDataManager;
import amrelmasry.com.core.models.environments.BaseCoreViewModelEnvironment;

import static amrelmasry.com.core.utils.general.ClassUtils.generateClassTag;

/**
 * Created by Amr on 11/02/17.
 */

public abstract class BaseCoreViewModel<I extends BaseCoreInputs,
        O extends BaseCoreOutputs, E extends BaseCoreViewModelEnvironment> {

    private final String TAG = generateClassTag(this);

    private I inputs;
    private O outputs;

    private E mViewModelEnvironment;

    public BaseCoreViewModel(E viewModelEnvironment) {
        this.mViewModelEnvironment = viewModelEnvironment;
        inputs = initInputs();
        outputs = initOutputs();
    }

    @NonNull
    protected abstract I initInputs();

    @NonNull
    protected abstract O initOutputs();

    @NonNull
    public I getInputs() {
        return inputs;
    }

    @NonNull
    public O getOutputs() {
        return outputs;
    }

    @NonNull
    protected E getEnvironment() {
        return mViewModelEnvironment;
    }

    @NonNull
    protected abstract BaseDataManager getDataManager();
}
