package amrelmasry.com.reactive_pop_movies.features.grid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import amrelmasry.com.core.adapter.BaseRecyclerViewAdapter;
import amrelmasry.com.reactive_pop_movies.R;
import amrelmasry.com.reactive_pop_movies.common.activity.BaseRecyclerViewActivity;
import amrelmasry.com.reactive_pop_movies.common.models.Movie;
import amrelmasry.com.reactive_pop_movies.features.grid.adapter.MoviesAdapter;
import amrelmasry.com.reactive_pop_movies.features.grid.adapter.viewholder.MoviesViewHolder;
import amrelmasry.com.reactive_pop_movies.features.grid.viewmodel.MoviesGridViewModel;
import butterknife.BindInt;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MoviesGridActivity extends BaseRecyclerViewActivity {

    @Inject
    MoviesGridViewModel mMoviesGridViewModel;

    @BindInt(R.integer.movies_grid_span_count)
    int mSpanCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mMoviesGridViewModel.getInputs().loadMovies();

        mMoviesGridViewModel.getOutputs()
                .moviesLoaded()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movies -> {
                            getRecyclerViewAdapter().addAll(movies);
                        },
                        throwable -> showError(throwable.getMessage()));
    }

    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected int initActivityLayout() {
        return R.layout.activity_movies_grid;
    }

    @NonNull
    @Override
    protected RecyclerView.LayoutManager setupRecyclerViewLayoutManager() {
        return new GridLayoutManager(this, mSpanCount);
    }

    @NonNull
    @Override
    protected BaseRecyclerViewAdapter<MoviesViewHolder, Movie> setupAdapter() {
        return new MoviesAdapter(new ArrayList<>());
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.movies_recycler_view;
    }

    @Override
    protected void injectDependencies() {
        getApp().getAppComponent().inject(this);
    }
}
