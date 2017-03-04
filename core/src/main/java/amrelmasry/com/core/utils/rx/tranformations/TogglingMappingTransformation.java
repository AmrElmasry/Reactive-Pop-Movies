package amrelmasry.com.core.utils.rx.tranformations;

import rx.Observable;

/**
 * Created by Amr on 04/03/17.
 */

public class TogglingMappingTransformation<T> implements Observable.Transformer<T, Boolean> {

    private boolean isToggled;

    public TogglingMappingTransformation() {
    }

    public TogglingMappingTransformation(final boolean isToggled) {
        this.isToggled = isToggled;
    }

    @Override
    public Observable<Boolean> call(Observable<T> upstream) {
        return upstream
                .doOnNext(__ -> this.flip())
                .map(__ -> isToggled);
    }

    private void flip() {
        isToggled = !isToggled;
    }
}
