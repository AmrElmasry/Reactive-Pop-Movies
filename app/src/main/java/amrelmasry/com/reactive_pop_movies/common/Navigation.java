package amrelmasry.com.reactive_pop_movies.common;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import amrelmasry.com.reactive_pop_movies.common.constantgroups.FilteringTypes;
import amrelmasry.com.reactive_pop_movies.common.models.Movie;
import amrelmasry.com.reactive_pop_movies.features.grid.MoviesFilteringDialogFragment;

/**
 * Created by Amr on 20/02/17.
 */

public class Navigation {

    public static void openMovieDetailsScreen(Context context, Movie movie) {

    }

    public static void showFilterScreen(FragmentManager fragmentManager,
                                        @FilteringTypes int prevSelected) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment prev = fragmentManager.findFragmentByTag("FilteringDialog");
        if (prev != null) {
            fragmentTransaction.remove(prev);
        }
        fragmentTransaction.addToBackStack(null);
        MoviesFilteringDialogFragment newFragment = MoviesFilteringDialogFragment.newInstance(prevSelected);
        newFragment.show(fragmentTransaction, "FilteringDialog");
    }
}
