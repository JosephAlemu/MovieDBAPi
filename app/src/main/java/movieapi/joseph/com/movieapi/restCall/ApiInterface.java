package movieapi.joseph.com.movieapi.restCall;



import io.reactivex.Observable;
import movieapi.joseph.com.movieapi.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by user on 2/23/2018.
 */

public interface ApiInterface {

    //https://api.themoviedb.org/3/search/movie?api_key=0a4213cbdd92888c0810478f905c2b7b&language=en-US&query=man&page=1&include_adult=false
    // base url  "https://api.themoviedb.org/3/";


    @GET("search/movie")
    Observable< Movie> getListOfMovies(
            @Query("api_key") String apiKey,
            @Query("lanugage") String lanugage,
            @Query("query") String query,
            @Query("page") int page,
            @Query("include_adult") String include_adult
    );

}
