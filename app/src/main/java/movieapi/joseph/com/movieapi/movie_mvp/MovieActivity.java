package movieapi.joseph.com.movieapi.movie_mvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import movieapi.joseph.com.movieapi.Application.MovieApplication;
import movieapi.joseph.com.movieapi.R;
import movieapi.joseph.com.movieapi.restCall.ApiInterface;
import movieapi.joseph.com.movieapi.model.Result;
import movieapi.joseph.com.movieapi.utils.MyAdapter;

public class MovieActivity extends AppCompatActivity implements MainContract.View , MyAdapter.ItemClickListener  {


    //https://api.themoviedb.org/3/search/movie?api_key=0a4213cbdd92888c0810478f905c2b7b&language=en-US&query=man&page=1&include_adult=false


    private Button btnSearch;
    private EditText etSearch;
    private RecyclerView rv;
    @Inject
    ApiInterface movieservice;

    BasePresenter basePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        btnSearch =(Button) findViewById(R.id.btnSearch);
        etSearch = (EditText)findViewById(R.id.etSearch);
        rv = (RecyclerView)findViewById(R.id.rvMovie);

        ((MovieApplication) getApplication()).getApiComponent().inject(this);

        basePresenter = new BasePresenter(this, movieservice);

    }


    @Override
    public void onsuccess(List<Result>  movies) {


            MyAdapter adapter = new MyAdapter(this,movies);
            RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
             rv.setAdapter(adapter);
            rv.setLayoutManager(manager);
            adapter.setClickListener(this);

    }

    @Override
    public void onfailure(String error) {

    }

    public void onSearchClicked(View view) {
        basePresenter.search(etSearch.getText().toString());
    }

    @Override
    public void onClick(String title, String imagePath, String detail, String releasedate) {



            Toast.makeText(this,   title, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MovieActivity.this, DetailActivity.class);
            intent.putExtra("title",title);
            intent.putExtra("imagePath", imagePath);
            intent.putExtra("detail", detail);
            intent.putExtra("releasedate", releasedate);
             startActivity(intent);


        }

}
