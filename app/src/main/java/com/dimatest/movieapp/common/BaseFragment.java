package com.dimatest.movieapp.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;

import com.dimatest.movieapp.BR;
import com.dimatest.movieapp.MainActivity;
import com.dimatest.movieapp.app.MovieApp;
import com.dimatest.movieapp.di.ViewModelFactory;
import com.dimatest.movieapp.di.component.AppComponent;

public abstract class BaseFragment<VM extends BaseViewModel, DB extends ViewDataBinding> extends Fragment {

    @LayoutRes
    protected abstract int getLayoutRes();
    protected VM viewModel;
    protected DB dataBinding;
    protected abstract ViewModelFactory getVmFactory();
    protected abstract VM buildViewModel(ViewModelProvider provider);
    protected abstract void injectToComponent();
    protected AppComponent appComponent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        appComponent = MovieApp.getApp().getAppComponent();
        injectToComponent();
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        viewModel = buildViewModel(ViewModelProviders.of(this, getVmFactory()));
        dataBinding.setVariable(BR.viewModel, viewModel);
        return dataBinding.getRoot();
    }

    private MainActivity getMainActivity() {
        return ((MainActivity) requireActivity());
    }

    private NavController getNavController() {
        return getMainActivity().navController;
    }

    public void navigate(int actionId) {
        getNavController().navigate(actionId);
    }

    public void navigate(NavDirections direction) {
        getNavController().navigate(direction);
    }
}
