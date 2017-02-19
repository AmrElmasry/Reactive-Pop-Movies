package amrelmasry.com.reactive_pop_movies.common.models;

import amrelmasry.com.reactive_pop_movies.common.utils.Constants;

/**
 * Created by Amr on 11/02/17.
 */

public class Movie {

    int id;
    String title;
    String poster_path;

    public Movie(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterUrl() {
        return Constants.MEDIA_PREFIX_URL + poster_path;
    }
}
