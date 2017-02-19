package amrelmasry.com.reactive_pop_movies.features.grid.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import amrelmasry.com.core.adapter.viewholder.BaseViewHolder;
import amrelmasry.com.reactive_pop_movies.R;
import amrelmasry.com.reactive_pop_movies.common.models.Movie;
import butterknife.BindView;

/**
 * Created by Amr on 11/02/17.
 */
public class MoviesViewHolder extends BaseViewHolder<Movie> {

    @BindView(R.id.movie_title_tv)
    TextView mMovieTitleTv;

    @BindView(R.id.movie_image_iv)
    ImageView mMovieAvatarIV;

    public MoviesViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(Movie movie) {
        mMovieTitleTv.setText(movie.getTitle());
        Picasso.with(getContext())
                .load(movie.getPosterUrl())
                .placeholder(R.drawable.movie_poster_image_holder)
                .into(mMovieAvatarIV);
    }
}
