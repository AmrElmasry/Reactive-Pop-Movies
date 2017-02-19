package amrelmasry.com.reactive_pop_movies.features.grid.adapter;


import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import amrelmasry.com.core.adapter.BaseRecyclerViewAdapter;
import amrelmasry.com.reactive_pop_movies.R;
import amrelmasry.com.reactive_pop_movies.common.models.Movie;
import amrelmasry.com.reactive_pop_movies.features.grid.adapter.viewholder.MoviesViewHolder;

/**
 * Created by Amr on 11/02/17.
 */

public class MoviesAdapter extends BaseRecyclerViewAdapter<MoviesViewHolder, Movie> {

    public MoviesAdapter(List<Movie> items) {
        super(items);
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflateItemView(parent, R.layout.list_item_movie);
        return new MoviesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        holder.bind(get(position));
    }

}
