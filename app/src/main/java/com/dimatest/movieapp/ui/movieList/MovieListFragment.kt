package com.dimatest.movieapp.ui.movieList

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.dimatest.movieapp.R
import com.dimatest.movieapp.common.BaseFragment
import com.dimatest.movieapp.database.entity.MovieDO
import com.dimatest.movieapp.databinding.FragmentMovieListBinding
import com.dimatest.movieapp.ui.movieList.adapter.MovieListAdapter
import com.dimatest.movieapp.ui.movieList.adapter.MovieListAdapter.MovieSelectedListener
import com.dimatest.movieapp.utils.safeLet
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : BaseFragment<MovieListViewModel, FragmentMovieListBinding>(), MovieSelectedListener {

    override val layoutRes = R.layout.fragment_movie_list
    override val viewModel: MovieListViewModel by viewModel()
    private val adapter: MovieListAdapter by lazy {
        MovieListAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(getString(R.string.main_title))
        setupList()
        observeModel()
        setupListeners()
    }

    private fun setupListeners() {
        dataBinding.swipeLayout.setOnRefreshListener { viewModel.loadFirstPage() }
    }

    private fun setupList() {
        dataBinding.movieListRv.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = this@MovieListFragment.adapter
        }
    }

    private fun observeModel() {
        viewModel.movieList.observe(viewLifecycleOwner, Observer { movies -> adapter.submitList(movies) })
        viewModel.moviesLoading().observe(viewLifecycleOwner, Observer { loading ->
            viewModel.isLoading.set(loading)
        })
    }

    override fun movieSelected(movie: MovieDO) {
        safeLet(movie.id, movie.title) { id, title ->
            navigate(MovieListFragmentDirections.actionMovieListFragmentToMovieDetailsFragment(id, title))
        }
    }

}