package com.dimatest.movieapp.utils;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

public class DataBindingAdapter {

    @BindingAdapter("loadPoster")
    public static void loadPoster(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .transform(new CenterCrop(), new RoundedCorners(24))
                .into(imageView);
    }

    @BindingAdapter("loadPosterWithBlur")
    public static void loadPosterWithBlur(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .transform(new BlurTransformation(imageView.getContext()))
                .into(imageView);
    }

    @BindingAdapter("rating")
    public static void setRating(TextView textView, Double rating) {
        textView.setText(String.valueOf(rating));
    }
}
