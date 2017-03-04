package amrelmasry.com.core.utils.rx;

import amrelmasry.com.core.utils.rx.tranformations.TogglingMappingTransformation;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Amr on 04/03/17.
 */

public class Transformations {

    /**
     * convert the upstream to stream of booleans, it begins with false value then toggle
     * the value for each emitted item
     *
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<T, Boolean> mapToToggling() {
        return new TogglingMappingTransformation<>();
    }

    public static <T> Observable.Transformer<T, T> applySchedulers() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}