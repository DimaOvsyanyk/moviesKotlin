package com.dimatest.movieapp.ui.movieDetails;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.dimatest.movieapp.R;
import com.dimatest.movieapp.common.BaseFragment;
import com.dimatest.movieapp.databinding.FragmentMovieDetailsBinding;
import com.dimatest.movieapp.di.ViewModelFactory;

import javax.inject.Inject;

public class MovieDetailsFragment extends BaseFragment<MovieDetailsViewModel, FragmentMovieDetailsBinding> {

    @Inject
    ViewModelFactory vmFactory;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_movie_details;
    }

    @Override
    protected ViewModelFactory getVmFactory() {
        return vmFactory;
    }

    @Override
    protected MovieDetailsViewModel buildViewModel(ViewModelProvider provider) {
        return provider.get(MovieDetailsViewModel.class);
    }

    @Override
    protected void injectToComponent() {
        appComponent.inject(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            MovieDetailsFragmentArgs args = MovieDetailsFragmentArgs.fromBundle(getArguments());
            long id = args.getMovieId();
            String title = args.getTitle();
            viewModel.getMovie(id);
            setTitle(title);
        }
    }
}
