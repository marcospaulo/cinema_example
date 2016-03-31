package gdg.activitytransitionsexample;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rv_movies)
    RecyclerView rvMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        rvMovies.setLayoutManager(new GridLayoutManager(this, 2));
        rvMovies.setAdapter(new MoviesAdapter(Movie.createMovies(), new MoviesAdapter.OnMovieClickListener() {
            @Override
            public void onMovieClick(Movie movie, ImageView ivMovieCover) {
                Intent intent = MovieDetailActivity.newIntent(MainActivity.this, movie);
                ivMovieCover.setTransitionName("movie_cover");
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, ivMovieCover, "movie_cover").toBundle());
            }
        }));

    }
}
