package com.dimatest.movieapp.ui.splash;

import android.animation.Animator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;

import com.dimatest.movieapp.R;
import com.dimatest.movieapp.common.BaseFragment;
import com.dimatest.movieapp.databinding.FragmentSplashScreenBinding;
import com.dimatest.movieapp.di.ViewModelFactory;

import javax.inject.Inject;

public class SplashScreenFragment extends BaseFragment<SplashScreenViewModel, FragmentSplashScreenBinding> {

    @Inject
    ViewModelFactory vmFactory;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_splash_screen;
    }

    @Override
    protected ViewModelFactory getVmFactory() {
        return vmFactory;
    }

    @Override
    protected SplashScreenViewModel buildViewModel(ViewModelProvider provider) {
        return provider.get(SplashScreenViewModel.class);
    }

    @Override
    protected void injectToComponent() {
        appComponent.inject(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataBinding.startAnimation.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) { }

            @Override
            public void onAnimationEnd(Animator animation) {
                navigate(R.id.action_splashScreenFragment_to_movieListFragment);
            }

            @Override
            public void onAnimationCancel(Animator animation) { }

            @Override
            public void onAnimationRepeat(Animator animation) { }
        });
    }
}
