package amrelmasry.com.core.utils;


import amrelmasry.com.core.models.PaginatedResponse;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by Amr on 20/02/17.
 */

public class Paginator {

    private static final int FIRST_PAGE = 0;
    private int page = FIRST_PAGE;
    private boolean mLastPageReached = false;

    public static Paginator create() {
        return new Paginator();
    }

    public Observable<Integer> getNextPage() {
        if (!mLastPageReached) {
            page++;
        }
        return Observable.just(page).observeOn(Schedulers.io());
    }

    public void processPaginatedResponse(PaginatedResponse<?> paginatedResponse) {
        if (paginatedResponse.isLastPage()) {
            mLastPageReached = true;
        }
    }
}
