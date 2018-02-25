package movieapi.joseph.com.movieapi.dependencies;

import javax.inject.Singleton;

import dagger.Component;
import movieapi.joseph.com.movieapi.movie_mvp.MovieActivity;

/**
 * Created by user on 2/23/2018.
 */
@Singleton
@Component(modules = {NetworkModule.class})
public interface ApiComponent {

    void inject(MovieActivity target);

}