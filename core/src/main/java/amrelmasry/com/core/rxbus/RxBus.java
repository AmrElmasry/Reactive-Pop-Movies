package amrelmasry.com.core.rxbus;

import rx.subjects.PublishSubject;

/**
 * Created by Amr on 20/02/17.
 */

class RxBus {
    private static PublishSubject<Object> bus = PublishSubject.create();

    public static PublishSubject<Object> get() {
        return bus;
    }

    static void send(Object o) {
        bus.onNext(o);
    }
}
