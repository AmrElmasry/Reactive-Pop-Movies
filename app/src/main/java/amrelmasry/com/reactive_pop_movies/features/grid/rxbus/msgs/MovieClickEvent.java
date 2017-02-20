package amrelmasry.com.reactive_pop_movies.features.grid.rxbus.msgs;

import amrelmasry.com.core.rxbus.msgs.BaseClickEvent;
import amrelmasry.com.reactive_pop_movies.common.models.Movie;

/**
 * Created by Amr on 20/02/17.
 */

public class MovieClickEvent extends BaseClickEvent {

    private Movie movie;

    public MovieClickEvent(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
