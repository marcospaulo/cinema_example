package gdg.activitytransitionsexample;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.SharedElementCallback;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

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

    @Bind(R.id.card_info)
    CardView cardInfo;

    public static Intent newIntent(Activity fromActivity, Movie movie) {
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

        ivMovieCover.setTransitionName("movie_cover");

        cardInfo.setTransitionGroup(false);
        makeEnterTransition();

        toolbar.setVisibility(View.INVISIBLE);
        setEnterSharedElementCallback(new SharedElementCallback() {
            @Override
            public void onSharedElementEnd(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
                final Animator animator = ViewAnimationUtils.createCircularReveal(toolbar, cardInfo.getRight() / 2, cardInfo.getTop() / 2, 0, cardInfo.getWidth() + cardInfo.getHeight());
                Handler handler = new Handler();
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.setDuration(600);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toolbar.setVisibility(View.VISIBLE);
                        animator.start();
                    }
                }, 300);
            }
        });
    }

    private void makeEnterTransition() {

        Slide slideFromBottom = new Slide(Gravity.BOTTOM);
        slideFromBottom.setDuration(500);
        slideFromBottom.setInterpolator(new DecelerateInterpolator());
        slideFromBottom.addTarget(R.id.tv_movie_description);
        slideFromBottom.addTarget(R.id.tv_movie_subtitle);
        slideFromBottom.addTarget(R.id.tv_movie_title);

        Fade fade = new Fade();
        fade.setDuration(1000);
        fade.addTarget(R.id.tv_movie_description);
        fade.addTarget(R.id.tv_movie_subtitle);
        fade.addTarget(R.id.tv_movie_title);

        TransitionSet transitionSetInfo = new TransitionSet();
        transitionSetInfo.addTransition(slideFromBottom);
        transitionSetInfo.addTransition(fade);


        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(transitionSetInfo);
        transitionSet.setOrdering(TransitionSet.ORDERING_SEQUENTIAL);

        getWindow().setEnterTransition(transitionSet);
    }

    @Override
    public void onBackPressed() {
        makeExitTransition();
        super.onBackPressed();
    }

    private void makeExitTransition(){
        cardInfo.setTransitionGroup(true);

        Slide slideFromUp = new Slide(Gravity.TOP);
        slideFromUp.setInterpolator(new AccelerateDecelerateInterpolator());
        slideFromUp.addTarget(R.id.toolbar);

        Slide slideFromBottom = new Slide(Gravity.BOTTOM);
        slideFromBottom.setInterpolator(new AccelerateDecelerateInterpolator());
        slideFromBottom.addTarget(R.id.card_info);

        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(slideFromBottom);
        transitionSet.addTransition(slideFromUp);

        getWindow().setExitTransition(transitionSet);
        getWindow().setReturnTransition(transitionSet);
    }
}
