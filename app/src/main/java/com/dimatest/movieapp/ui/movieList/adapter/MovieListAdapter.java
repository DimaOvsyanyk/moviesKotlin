package com.dimatest.movieapp.ui.movieList.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.dimatest.movieapp.R;
import com.dimatest.movieapp.common.BasePagedListAdaper;
import com.dimatest.movieapp.common.BaseViewHolder;
import com.dimatest.movieapp.database.entity.MovieDO;
import com.dimatest.movieapp.databinding.ItemMovieBinding;

public class MovieListAdapter extends BasePagedListAdaper<MovieDO, MovieListAdapter.MovieListViewHolder, ItemMovieBinding> {

    public interface MovieSelectedListener{
        void movieSelected(MovieDO movie);
    }

    private MovieSelectedListener listener;

    public MovieListAdapter(MovieSelectedListener listener) {
        super(diffCallback);
        this.listener = listener;
    }

    private static final DiffUtil.ItemCallback<MovieDO> diffCallback = new DiffUtil.ItemCallback<MovieDO>() {
        @Override
        public boolean areItemsTheSame(@NonNull MovieDO oldItem, @NonNull MovieDO newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull MovieDO oldItem, @NonNull MovieDO newItem) {
            return oldItem.equals(newItem);
        }
    };

    @Override
    public int getLayoutRes() {
        return R.layout.item_movie;
    }

    @Override
    protected MovieListViewHolder getViewHolder(ItemMovieBinding binding) {
        return new MovieListViewHolder(binding);
    }

    class MovieListViewHolder extends BaseViewHolder<ItemMovieBinding, MovieDO> {

        MovieListViewHolder(@NonNull ItemMovieBinding dataBinding) {
            super(dataBinding);
        }

        @Override
        public void bind(MovieDO item) {
            super.bind(item);
            itemView.setOnClickListener(__ -> listener.movieSelected(item));
        }
    }
}
