package movieapi.joseph.com.movieapi.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import movieapi.joseph.com.movieapi.R;
import movieapi.joseph.com.movieapi.model.Result;

/**
 * Created by user on 2/24/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.viewHolder>
{

    private final List<Result> movieslist;
    private final Context context;
    private ItemClickListener clickListener;

    public MyAdapter( Context context,List<Result> movieslist) {
        this.movieslist = movieslist;
        this.context = context;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder,  int position) {


        holder.tvTitle.setText(movieslist.get(position).getTitle());
                  Glide.with(context).load(Constant.IMAGE_BASE + movieslist.get(position)
                          .getPosterPath())
                          .into(holder.ivPic);


    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return movieslist.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvTitle;
        private ImageView ivPic;

        private LinearLayout linearLayout;



        public viewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivPic = itemView.findViewById(R.id.ivPic);




            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if (clickListener != null) {


                Result movie = movieslist.get( getAdapterPosition());
                String  title= movie.getTitle();
                String imagePath= Constant.IMAGE_BASE+movie.getPosterPath();
                String  detail= movie.getOverview();
                String releasedate = movie.getReleaseDate() ;

                clickListener.onClick(title,imagePath,detail,releasedate);
            }

        }


    }

    public interface ItemClickListener {
        void onClick( String  title,String imagePath,String  detail,String releasedate );
    }

}