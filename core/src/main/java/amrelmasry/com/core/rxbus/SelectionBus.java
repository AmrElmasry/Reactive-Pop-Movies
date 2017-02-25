package amrelmasry.com.core.rxbus;

import amrelmasry.com.core.rxbus.msgs.BaseSelectionEvent;
import rx.Observable;

/**
 * Created by Amr on 25/02/17.
 */

public class SelectionBus {

    public static void send(BaseSelectionEvent selectionEvent) {
        RxBus.send(selectionEvent);
    }

    public static Observable<BaseSelectionEvent> receive() {
        return RxBus.get().ofType(BaseSelectionEvent.class);
    }
}
