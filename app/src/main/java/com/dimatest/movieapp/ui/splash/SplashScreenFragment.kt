package com.dimatest.movieapp.ui.splash

import android.animation.Animator
import android.os.Bundle
import android.view.View
import com.dimatest.movieapp.R
import com.dimatest.movieapp.common.BaseFragment
import com.dimatest.movieapp.databinding.FragmentSplashScreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashScreenFragment : BaseFragment<SplashScreenViewModel, FragmentSplashScreenBinding>() {

    override val layoutRes = R.layout.fragment_splash_screen
    override val viewModel: SplashScreenViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.startAnimation.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) {
                navigate(R.id.action_splashScreenFragment_to_movieListFragment)
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
    }
}