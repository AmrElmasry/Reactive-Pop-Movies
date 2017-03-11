package amrelmasry.com.reactive_pop_movies.common.models;

import amrelmasry.com.reactive_pop_movies.common.utils.Constants;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Amr on 11/02/17.
 */

public class Movie extends RealmObject {

    @PrimaryKey
    private int id;
    private String title;
    private String poster_path;
    private String overview;
    private String vote_average;
    private String release_date;

    public Movie() {
    }

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

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
