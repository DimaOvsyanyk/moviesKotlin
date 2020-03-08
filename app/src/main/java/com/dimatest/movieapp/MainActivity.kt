package com.dimatest.movieapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dimatest.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val navController: NavController by lazy {
        Navigation.findNavController(this, R.id.main_nav_host)
    }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.backBtn.setOnClickListener { navController.navigateUp() }
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.toolbarLayout.visibility = if (destination.id == R.id.splashScreenFragment) View.GONE else View.VISIBLE
            binding.backBtn.visibility = if (destination.id == R.id.movieListFragment) View.GONE else View.VISIBLE
        }
    }

    fun setTitle(title: String?) {
        binding.toolbarTitleTv.text = title
    }
}