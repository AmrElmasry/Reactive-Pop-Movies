package amrelmasry.com.reactive_pop_movies.common.constantgroups;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static amrelmasry.com.reactive_pop_movies.common.constantgroups.FilteringTypes.HIGHEST_RATED_FILTER;
import static amrelmasry.com.reactive_pop_movies.common.constantgroups.FilteringTypes.MOST_POPULAR_FILTER;

/**
 * Created by Amr on 25/02/17.
 */

@Retention(RetentionPolicy.SOURCE)
@IntDef({MOST_POPULAR_FILTER, HIGHEST_RATED_FILTER})
public @interface FilteringTypes {
    int MOST_POPULAR_FILTER = 0;
    int HIGHEST_RATED_FILTER = 1;
}
