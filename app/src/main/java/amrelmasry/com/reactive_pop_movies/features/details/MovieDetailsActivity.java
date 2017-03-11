package amrelmasry.com.reactive_pop_movies.features.details;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import amrelmasry.com.reactive_pop_movies.R;
import amrelmasry.com.reactive_pop_movies.common.activity.BaseActivity;
import amrelmasry.com.reactive_pop_movies.common.models.Movie;
import amrelmasry.com.reactive_pop_movies.common.utils.Constants;
import amrelmasry.com.reactive_pop_movies.features.details.viewmodel.MovieDetailsViewModel;
import butterknife.BindView;

import static amrelmasry.com.core.utils.rx.Transformations.applySchedulers;
import static amrelmasry.com.core.utils.rx.Transformations.mapToToggling;

public class MovieDetailsActivity extends BaseActivity {


    @Inject
    MovieDetailsViewModel mMovieDetailsViewModel;

    @BindView(R.id.movie_poster_iv)
    ImageView mMoviePosterIv;
    @BindView(R.id.movie_title)
    TextView mMovieTitleTv;
    @BindView(R.id.movie_rating)
    TextView mMovieRatingTv;
    @BindView(R.id.movie_release_date)
    TextView mMovieReleaseDateTv;
    @BindView(R.id.movie_overview)
    TextView mMovieOverviewTv;
    @BindView(R.id.star_fab)
    FloatingActionButton mAddToFavoritesFab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int movieId = getMovieIdFromIntent();

        enableToolbarUpButton(R.id.toolbar);

        mMovieDetailsViewModel.getInputs().loadMovieDetails(movieId);

        RxView.clicks(mAddToFavoritesFab)
                .compose(mapToToggling())
                .compose(bindToLifecycle())
                .subscribe(addToFavorites -> {
                    if (addToFavorites) {
                        Toast.makeText(this, "Adding to favorites..", Toast.LENGTH_SHORT).show();
                        mAddToFavoritesFab.setImageDrawable(ContextCompat.getDrawable(
                                this, R.drawable.ic_star_golden));
                    } else {
                        Toast.makeText(this, "Removing from favorites..", Toast.LENGTH_SHORT).show();
                        mAddToFavoritesFab.setImageDrawable(ContextCompat.getDrawable(
                                this, R.drawable.ic_star_gray));
                    }
                });


        mMovieDetailsViewModel.getOutputs()
                .onMoviesLoaded()
                .compose(applySchedulers())
                .compose(bindToLifecycle())
                .subscribe(this::populateMovieInfo,
                        throwable -> {
                            throwable.printStackTrace();
                            showError(throwable.getMessage());
                        });
    }

    private int getMovieIdFromIntent() {
        int movieId = getIntent().getIntExtra(Constants.Extras.MOVIE_ID, -1);
        if (movieId == -1) {
            throw new IllegalStateException("Not Valid Movie Id");
        }
        return movieId;
    }

    private void populateMovieInfo(Movie movie) {
        Picasso.with(this)
                .load(movie.getPosterUrl())
                .placeholder(R.drawable.movie_poster_image_holder)
                .into(mMoviePosterIv);
        mMovieOverviewTv.setText(movie.getOverview());
        mMovieRatingTv.setText(movie.getVote_average());
        mMovieReleaseDateTv.setText(movie.getRelease_date());
        mMovieTitleTv.setText(movie.getTitle());
    }

    @Override
    protected int initActivityLayout() {
        return R.layout.activity_movie_details;
    }

    @Override
    protected void injectDependencies() {
        getApp().getAppComponent().inject(this);
    }
}
