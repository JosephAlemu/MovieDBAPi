package movieapi.joseph.com.movieapi.Application;

import android.app.Application;

import movieapi.joseph.com.movieapi.dependencies.ApiComponent;
import movieapi.joseph.com.movieapi.dependencies.DaggerApiComponent;
import movieapi.joseph.com.movieapi.dependencies.NetworkModule;
import movieapi.joseph.com.movieapi.utils.Constant;

/**
 * Created by user on 2/23/2018.
 */

public class MovieApplication extends Application{


    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }


    private void resolveDependency() {


        mApiComponent =  DaggerApiComponent.builder()
                         .networkModule(new NetworkModule(Constant.BASE_URL))
                           .build();
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }


}
