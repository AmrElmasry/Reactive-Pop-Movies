package amrelmasry.com.reactive_pop_movies.features.grid.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import amrelmasry.com.core.adapter.viewholder.BaseViewHolder;
import amrelmasry.com.core.rxbus.ClicksBus;
import amrelmasry.com.core.utils.annotations.ShownIn;
import amrelmasry.com.reactive_pop_movies.R;
import amrelmasry.com.reactive_pop_movies.common.models.Movie;
import amrelmasry.com.reactive_pop_movies.features.grid.MoviesGridActivity;
import amrelmasry.com.reactive_pop_movies.features.grid.rxbus.msgs.MovieClickEvent;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Amr on 11/02/17.
 */

@ShownIn(MoviesGridActivity.class)
public class MoviesViewHolder extends BaseViewHolder<Movie> {

    @BindView(R.id.movie_title_tv)
    TextView mMovieTitleTv;

    @BindView(R.id.movie_image_iv)
    ImageView mMovieAvatarIV;
    private Movie mMovie;

    public MoviesViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(Movie movie) {
        mMovie = movie;
        mMovieTitleTv.setText(movie.getTitle());
        Picasso.with(getContext())
                .load(movie.getPosterUrl())
                .placeholder(R.drawable.movie_poster_image_holder)
                .into(mMovieAvatarIV);
    }

    @OnClick(R.id.grid_movie_item_container)
    void onMovieClicked() {
        ClicksBus.send(new MovieClickEvent(mMovie));
    }
}
