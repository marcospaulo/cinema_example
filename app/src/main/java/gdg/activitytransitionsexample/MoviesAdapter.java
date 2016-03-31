package gdg.activitytransitionsexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private List<Movie> movies;

    private Context context;
    private OnMovieClickListener onMovieClickListener;

    public MoviesAdapter(List<Movie> movies, OnMovieClickListener onMovieClickListener) {
        this.movies = movies;
        this.onMovieClickListener = onMovieClickListener;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        final MoviesViewHolder viewHolder = new MoviesViewHolder(view);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMovieClickListener.onMovieClick(movies.get(viewHolder.getAdapterPosition()));
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        Movie currentMovie = movies.get(position);

        holder.ivMovieCover.setImageResource(currentMovie.resImageCover);
        holder.tvMovieTitle.setText(currentMovie.name);
        holder.tvMovieSubtitle.setText(currentMovie.subtitle);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MoviesViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_movie_cover)
        ImageView ivMovieCover;

        @Bind(R.id.tv_movie_title)
        TextView tvMovieTitle;

        @Bind(R.id.tv_movie_subtitle)
        TextView tvMovieSubtitle;

        public MoviesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnMovieClickListener {
        void onMovieClick(Movie movie);
    }
}
