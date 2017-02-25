package amrelmasry.com.core.models;

import java.util.List;

/**
 * Created by Amr on 11/02/17.
 */


public class PaginatedResponse<T> {

    public int page;

    public List<T> results;

    public int totalResults;

    public int totalPages;

    public int getPage() {
        return page;
    }

    public List<T> getResults() {
        return results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public boolean isLastPage() {
        return page == totalPages;
    }
}
