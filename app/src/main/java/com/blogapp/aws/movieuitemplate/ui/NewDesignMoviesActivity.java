package com.blogapp.aws.movieuitemplate.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogapp.aws.movieuitemplate.MyApplication;
import com.blogapp.aws.movieuitemplate.R;
import com.blogapp.aws.movieuitemplate.adapters.MovieItemClickListener;
import com.blogapp.aws.movieuitemplate.adapters.NewDesignMovieAdapter;
import com.blogapp.aws.movieuitemplate.models.Movie;
import com.bumptech.glide.Glide;
import com.dingmouren.layoutmanagergroup.skidright.SkidRightLayoutManager;

import java.util.ArrayList;
import java.util.List;

//import com.blogapp.aws.movieuitemplate.skidright.SkidRightLayoutManager;

public class NewDesignMoviesActivity extends AppCompatActivity
        implements MovieItemClickListener {

    private RecyclerView mRecyclerView;
    private SkidRightLayoutManager mSkidRightLayoutManager;

    private RecyclerView MoviesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_design_movies);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        if(getSupportActionBar()!=null)
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();

        MoviesRV = findViewById(R.id.rv_movies);

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Moana", R.drawable.moana, R.drawable.spidercover));
        lstMovies.add(new Movie("Black P", R.drawable.blackp, R.drawable.spidercover));
        lstMovies.add(new Movie("The Martian", R.drawable.themartian));
        lstMovies.add(new Movie("The Martian", R.drawable.themartian));
        lstMovies.add(new Movie("The Martian", R.drawable.themartian));
        lstMovies.add(new Movie("The Martian", R.drawable.themartian));

        NewDesignMovieAdapter movieAdapter = new NewDesignMovieAdapter(this, lstMovies, this);
        MoviesRV.setAdapter(movieAdapter);
//        MoviesRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }


    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);

        mSkidRightLayoutManager = new SkidRightLayoutManager(1.5f, 0.85f);
        mRecyclerView.setLayoutManager(mSkidRightLayoutManager);
        mRecyclerView.setAdapter(new MyAdapter());
    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {

    }

    /**
     * 适配器
     */
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private int[] imgs = {
                R.drawable.blackp,
                R.drawable.moana,
                R.drawable.mov2,
                R.drawable.slide1,
                R.drawable.slide2,

//                R.mipmap.skid_right_1,
//                R.mipmap.skid_right_2,
//                R.mipmap.skid_right_3,
//                R.mipmap.skid_right_4,
//                R.mipmap.skid_right_5,
//                R.mipmap.skid_right_6,
//                R.mipmap.skid_right_7,

        };
        String[] titles = {"Acknowl", "Belief", "Confidence", "Dreaming", "Happiness", "Confidence"};

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MyApplication.sContext).inflate(R.layout.item_movie_design, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {

            Glide.with(MyApplication.sContext).load(imgs[position % 7])
//                        .asGif()
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(holder.imgBg);
            holder.tvTitle.setText(titles[position % 6]);
            holder.imgBg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(SkidRightActivity_1.this, SkidRightActivity_2.class);
//                    intent.putExtra("img", imgs[position % 7]);
//                    intent.putExtra("title", titles[position % 6]);
//                    Pair<View, String> p1 = Pair.create((View)holder.imgBg, "img_view_1");
//                    Pair<View, String> p2 = Pair.create((View)holder.tvTitle, "title_1");
//                    Pair<View, String> p3 = Pair.create((View)holder.tvBottom, "tv_bottom");
//                    ActivityOptionsCompat options = ActivityOptionsCompat.
//                            makeSceneTransitionAnimation(SkidRightActivity_1.this, p1,p2,p3);
//                    startActivity(intent,options.toBundle());
                }
            });
        }

        @Override
        public int getItemCount() {
            return imgs.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imgBg;
            TextView tvTitle;
            TextView tvBottom;

            public ViewHolder(View itemView) {
                super(itemView);
                imgBg = itemView.findViewById(R.id.img_bg);
                tvTitle = itemView.findViewById(R.id.tv_title);
                tvBottom = itemView.findViewById(R.id.tv_bottom);
            }
        }
    }
}
