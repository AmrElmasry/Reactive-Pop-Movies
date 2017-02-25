package amrelmasry.com.reactive_pop_movies.features.grid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import amrelmasry.com.core.adapter.BaseRecyclerViewAdapter;
import amrelmasry.com.core.rxbus.ClicksBus;
import amrelmasry.com.reactive_pop_movies.R;
import amrelmasry.com.reactive_pop_movies.common.Navigation;
import amrelmasry.com.reactive_pop_movies.common.activity.BaseRecyclerViewActivity;
import amrelmasry.com.reactive_pop_movies.common.models.Movie;
import amrelmasry.com.reactive_pop_movies.common.utils.EndlessRecyclerViewScrollListener;
import amrelmasry.com.reactive_pop_movies.features.grid.adapter.MoviesAdapter;
import amrelmasry.com.reactive_pop_movies.features.grid.adapter.viewholder.MoviesViewHolder;
import amrelmasry.com.reactive_pop_movies.features.grid.rxbus.msgs.MovieClickEvent;
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

        setupEndlessScrolling();

        mMoviesGridViewModel.getOutputs()
                .moviesLoaded()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movies -> {
                            getRecyclerViewAdapter().addAll(movies);
                        },
                        throwable -> {
                            throwable.printStackTrace();
                            showError(throwable.getMessage());
                        });

        ClicksBus.receive()
                .ofType(MovieClickEvent.class)
                .map(MovieClickEvent::getMovie)
                .subscribe(movie -> Navigation.openMovieDetailsScreen(this, movie));

    }

    private void setupEndlessScrolling() {
        getRecyclerView().addOnScrollListener(
                new EndlessRecyclerViewScrollListener((LinearLayoutManager) getRecyclerViewLayoutManager()) {
                    @Override
                    public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                        mMoviesGridViewModel.getInputs().loadMovies();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movies_grid_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.filter_action_btn) {
            Navigation.showFilterScreen();
            return true;
        }
        return super.onOptionsItemSelected(item);
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
