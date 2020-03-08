package com.dimatest.movieapp.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.dimatest.movieapp.BR
import com.dimatest.movieapp.MainActivity

abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> : Fragment() {
    @get:LayoutRes
    protected abstract val layoutRes: Int
    protected abstract val viewModel: VM
    protected lateinit var dataBinding: DB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        dataBinding.setVariable(BR.viewModel, viewModel)
        return dataBinding.root
    }

    protected fun setTitle(title: String?) {
        mainActivity.setTitle(title)
    }

    private val mainActivity: MainActivity
        get() = requireActivity() as MainActivity

    private val navController: NavController
        get() = mainActivity.navController

    fun navigate(actionId: Int) {
        navController.navigate(actionId)
    }

    fun navigate(direction: NavDirections) {
        navController.navigate(direction)
    }
}