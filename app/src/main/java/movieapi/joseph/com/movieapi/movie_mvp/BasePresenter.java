package movieapi.joseph.com.movieapi.movie_mvp;


import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import movieapi.joseph.com.movieapi.model.Movie;
import movieapi.joseph.com.movieapi.model.Result;
import movieapi.joseph.com.movieapi.restCall.ApiInterface;
import movieapi.joseph.com.movieapi.utils.Constant;

/**
 * Created by user on 2/23/2018.
 */
public  class BasePresenter implements MainContract.Presenter {

    List<Result> list;
    ApiInterface movieservice;
    MainContract.View view;
    String QUERY;
    public BasePresenter(MainContract.View view,ApiInterface movieservice) {
        this.view = view;
        this.movieservice = movieservice;
    }


    public void fetchData(){

        movieservice.getListOfMovies( Constant.API_KEY,Constant.LANGUAGE, QUERY,
                Constant.PAGE,Constant.INCLUDE_ADULT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Movie>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Movie movie) {
                        list = movie.getResults();
                        view.onsuccess(list );
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        view.onfailure("error");

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    @Override
    public void search(String title) {
          QUERY = title;
          fetchData();
    }
}