package movieapi.joseph.com.movieapi.movie_mvp;

import java.util.List;

import movieapi.joseph.com.movieapi.model.Result;

/**
 * Created by user on 2/24/2018.
 */

public interface MainContract {



        interface View  {


            void onsuccess( List<Result> list);

            void  onfailure(String error);

        }

        interface Presenter  {

            void  search(String title);

        }

}
