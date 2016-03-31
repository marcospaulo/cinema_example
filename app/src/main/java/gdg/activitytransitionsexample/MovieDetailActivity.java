package gdg.activitytransitionsexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieDetailActivity extends AppCompatActivity {

    private static final String EXTRA_MOVIE = "extra_movie";

    private Movie movie;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.iv_movie_cover)
    ImageView ivMovieCover;

    @Bind(R.id.tv_movie_title)
    TextView tvMovieTitle;

    @Bind(R.id.tv_movie_subtitle)
    TextView tvMovieSubtitle;

    @Bind(R.id.tv_movie_description)
    TextView tvMovieDescription;

    public static Intent newIntent(Activity fromActivity, Movie movie){
        Intent intent = new Intent(fromActivity, MovieDetailActivity.class);
        intent.putExtra(EXTRA_MOVIE, movie);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        movie = (Movie) getIntent().getSerializableExtra(EXTRA_MOVIE);

        toolbar.setBackgroundResource(movie.resImageBanner);
        ivMovieCover.setImageResource(movie.resImageCover);
        tvMovieTitle.setText(movie.name);
        tvMovieSubtitle.setText(movie.subtitle);
        tvMovieDescription.setText(movie.description);

    }
}
