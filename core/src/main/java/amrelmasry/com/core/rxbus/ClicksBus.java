package amrelmasry.com.core.rxbus;

import amrelmasry.com.core.rxbus.msgs.BaseClickEvent;
import rx.Observable;

/**
 * Created by Amr on 20/02/17.
 */

public class ClicksBus {

    public static void send(BaseClickEvent clickEvent) {
        RxBus.send(clickEvent);
    }

    public static Observable<BaseClickEvent> receive() {
        return RxBus.get().ofType(BaseClickEvent.class);
    }
}
