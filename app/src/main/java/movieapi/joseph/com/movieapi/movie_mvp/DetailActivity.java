package movieapi.joseph.com.movieapi.movie_mvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import movieapi.joseph.com.movieapi.R;

public class DetailActivity extends AppCompatActivity {
    private ImageView image;
    private TextView etDetail;
    private TextView etReleaseDate;
    private TextView etTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        image = findViewById(R.id.ivImage);
        etTitle = findViewById(R.id.etTitle);
        etDetail = findViewById(R.id.etDetail);
        etReleaseDate = findViewById(R.id.etReleaseDate);

        Intent extra = getIntent();

        Glide.with(this).load(extra.getStringExtra("imagePath")).into(image);

        etDetail.setText(extra.getStringExtra("detail"));
        etReleaseDate.setText(extra.getStringExtra("releasedate"));
        etTitle.setText(extra.getStringExtra("title"));



    }
}
