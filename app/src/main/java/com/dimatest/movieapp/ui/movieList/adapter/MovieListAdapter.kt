package com.dimatest.movieapp.ui.movieList.adapter

import androidx.recyclerview.widget.DiffUtil
import com.dimatest.movieapp.R
import com.dimatest.movieapp.common.BasePagedListAdapter
import com.dimatest.movieapp.common.BaseViewHolder
import com.dimatest.movieapp.database.entity.MovieDO
import com.dimatest.movieapp.databinding.ItemMovieBinding
import com.dimatest.movieapp.ui.movieList.adapter.MovieListAdapter.MovieListViewHolder

class MovieListAdapter(private val listener: MovieSelectedListener) : BasePagedListAdapter<MovieDO, MovieListViewHolder, ItemMovieBinding>(diffCallback) {
    interface MovieSelectedListener {
        fun movieSelected(movie: MovieDO)
    }

    override val layoutRes = R.layout.item_movie
    override fun getViewHolder(binding: ItemMovieBinding) = MovieListViewHolder(binding)

    inner class MovieListViewHolder(dataBinding: ItemMovieBinding) : BaseViewHolder<ItemMovieBinding, MovieDO>(dataBinding) {
        override fun bind(item: MovieDO) {
            super.bind(item)
            itemView.setOnClickListener { listener.movieSelected(item) }
        }
    }

    companion object {
        private val diffCallback: DiffUtil.ItemCallback<MovieDO> = object : DiffUtil.ItemCallback<MovieDO>() {
            override fun areItemsTheSame(oldItem: MovieDO, newItem: MovieDO): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieDO, newItem: MovieDO): Boolean {
                return oldItem == newItem
            }
        }
    }

}