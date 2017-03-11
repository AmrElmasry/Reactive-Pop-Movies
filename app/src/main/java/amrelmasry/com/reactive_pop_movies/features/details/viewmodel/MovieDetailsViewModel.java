package amrelmasry.com.reactive_pop_movies.features.details.viewmodel;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import amrelmasry.com.core.rxbus.msgs.BaseRealmEvent;
import amrelmasry.com.reactive_pop_movies.common.models.Movie;
import amrelmasry.com.reactive_pop_movies.common.models.environments.ViewModelEnvironment;
import amrelmasry.com.reactive_pop_movies.common.viewmodel.BaseViewModel;
import amrelmasry.com.reactive_pop_movies.features.grid.rxbus.msgs.RealmAdditionSuccessEvent;
import amrelmasry.com.reactive_pop_movies.features.grid.rxbus.msgs.RealmRemovingSuccessEvent;
import io.realm.Realm;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/**
 * Created by Amr on 25/02/17.
 */

public class MovieDetailsViewModel
        extends BaseViewModel<MovieDetailsInputs, MovieDetailsOutputs>
        implements MovieDetailsOutputs, MovieDetailsInputs {

    private final BehaviorSubject<Integer> moviesIdsStream = BehaviorSubject.create();
    private final PublishSubject<BaseRealmEvent> realmSuccessEventsStream = PublishSubject.create();

    @Inject
    public MovieDetailsViewModel(ViewModelEnvironment viewModelEnvironment) {
        super(viewModelEnvironment);
    }


    @Override
    public void loadMovieDetails(int movieId) {
        moviesIdsStream.onNext(movieId);
    }

    @Override
    public void addToFavorites(final Movie movieToAdd) {
        Realm.getDefaultInstance().executeTransactionAsync(realm -> {
            realm.copyToRealm(movieToAdd);
        }, () -> realmSuccessEventsStream.onNext(new RealmAdditionSuccessEvent()));
    }

    @Override
    public void removeFromFavorites(final Movie movie) {
        Realm.getDefaultInstance().executeTransactionAsync(realm -> {
            realm.where(Movie.class).equalTo("id", movie.getId()).findFirst().deleteFromRealm();
        }, () -> realmSuccessEventsStream.onNext(new RealmRemovingSuccessEvent()));
    }

    @Override
    public Observable<Movie> onMovieLoaded() {
        return moviesIdsStream.flatMap(movieId -> getDataManager().getMovieDetails(movieId));
    }

    @Override
    public Observable<RealmAdditionSuccessEvent> onMovieAddedToFavorites() {
        return realmSuccessEventsStream.ofType(RealmAdditionSuccessEvent.class);
    }

    @Override
    public Observable<RealmRemovingSuccessEvent> onMovieRemovedFromFavorites() {
        return realmSuccessEventsStream.ofType(RealmRemovingSuccessEvent.class);
    }


    @NonNull
    @Override
    protected MovieDetailsInputs initInputs() {
        return this;
    }

    @NonNull
    @Override
    protected MovieDetailsOutputs initOutputs() {
        return this;
    }


}
