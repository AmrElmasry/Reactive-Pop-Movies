package amrelmasry.com.reactive_pop_movies.common;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import amrelmasry.com.reactive_pop_movies.common.constantgroups.FilteringTypes;
import amrelmasry.com.reactive_pop_movies.common.models.Movie;
import amrelmasry.com.reactive_pop_movies.common.utils.Constants;
import amrelmasry.com.reactive_pop_movies.features.details.MovieDetailsActivity;
import amrelmasry.com.reactive_pop_movies.features.grid.MoviesFilteringDialogFragment;

/**
 * Created by Amr on 20/02/17.
 */

public class Navigation {

    public static void openMovieDetailsScreen(Context context, Movie movie) {
        Intent intent = new Intent(context, MovieDetailsActivity.class);
        intent.putExtra(Constants.Extras.MOVIE_ID, movie.getId());
        context.startActivity(intent);
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
