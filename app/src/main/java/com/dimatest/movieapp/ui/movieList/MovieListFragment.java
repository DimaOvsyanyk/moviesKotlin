package com.dimatest.movieapp.ui.movieList;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.dimatest.movieapp.R;
import com.dimatest.movieapp.common.BaseFragment;
import com.dimatest.movieapp.database.entity.MovieDO;
import com.dimatest.movieapp.databinding.FragmentMovieListBinding;
import com.dimatest.movieapp.di.ViewModelFactory;
import com.dimatest.movieapp.ui.movieList.adapter.MovieListAdapter;

import javax.inject.Inject;

public class MovieListFragment extends BaseFragment<MovieListViewModel, FragmentMovieListBinding>
        implements MovieListAdapter.MovieSelectedListener {

    @Inject
    ViewModelFactory vmFactory;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_movie_list;
    }

    @Override
    protected ViewModelFactory getVmFactory() {
        return vmFactory;
    }

    @Override
    protected MovieListViewModel buildViewModel(ViewModelProvider provider) {
        return provider.get(MovieListViewModel.class);
    }

    @Override
    protected void injectToComponent() {
        appComponent.inject(this);
    }

    private MovieListAdapter adapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitle(getString(R.string.main_title));
        adapter = new MovieListAdapter(this);
        setupList();
        observeModel();
        setupListeners();
    }

    private void setupListeners() {
        dataBinding.swipeLayout.setOnRefreshListener(() -> viewModel.loadFirstPage());
    }

    private void setupList() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 2);
        dataBinding.movieListRv.setLayoutManager(gridLayoutManager);
        dataBinding.movieListRv.setAdapter(adapter);
    }

    private void observeModel() {
        viewModel.getMovieList().observe(getViewLifecycleOwner(), movies -> adapter.submitList(movies));
        viewModel.getMoviesLoading().observe(getViewLifecycleOwner(), loading -> {
            dataBinding.swipeLayout.setRefreshing(loading);
            viewModel.setMoviesLoading(loading);
        });
    }

    @Override
    public void movieSelected(MovieDO movie) {
        navigate(MovieListFragmentDirections.actionMovieListFragmentToMovieDetailsFragment(movie.getId(), movie.getTitle()));
    }
}
