package com.dimatest.movieapp.ui.movieDetails

import android.os.Bundle
import android.view.View
import com.dimatest.movieapp.R
import com.dimatest.movieapp.common.BaseFragment
import com.dimatest.movieapp.databinding.FragmentMovieDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsFragment : BaseFragment<MovieDetailsViewModel, FragmentMovieDetailsBinding>() {

    override val layoutRes = R.layout.fragment_movie_details
    override val viewModel: MovieDetailsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val args = MovieDetailsFragmentArgs.fromBundle(it)
            val id = args.movieId
            val title = args.title
            viewModel.getMovie(id)
            setTitle(title)
        }
    }
}