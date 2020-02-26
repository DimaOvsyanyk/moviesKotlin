package com.dimatest.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.View;

import com.dimatest.movieapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public NavController navController;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        navController = Navigation.findNavController(this, R.id.main_nav_host);
        binding.backBtn.setOnClickListener(__ -> navController.navigateUp());
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
                    binding.toolbarLayout.setVisibility((destination.getId() == R.id.splashScreenFragment) ? View.GONE : View.VISIBLE);
                    binding.backBtn.setVisibility((destination.getId() == R.id.movieListFragment) ? View.GONE : View.VISIBLE);
                }
        );
    }

    public void setTitle(String title) {
        binding.toolbarTitleTv.setText(title);
    }
}
