package amrelmasry.com.core.utils;


import amrelmasry.com.core.models.PaginatedResponse;

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

    public int getNextPage() {
        if (!mLastPageReached) {
            page++;
        }
        return page;
    }

    public void processPaginatedResponse(PaginatedResponse<?> paginatedResponse) {
        if (paginatedResponse.isLastPage()) {
            mLastPageReached = true;
        }
    }

    public void reset() {
        page = FIRST_PAGE;
    }
}
