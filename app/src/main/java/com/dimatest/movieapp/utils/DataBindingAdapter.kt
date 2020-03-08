package com.dimatest.movieapp.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

@BindingAdapter("loadPoster")
fun loadPoster(imageView: ImageView, url: String?) {
    Glide.with(imageView.context)
            .load(url)
            .transform(CenterCrop(), RoundedCorners(24))
            .into(imageView)
}

@BindingAdapter("loadPosterWithBlur")
fun loadPosterWithBlur(imageView: ImageView, url: String?) {
    Glide.with(imageView.context)
            .load(url)
            .transform(BlurTransformation(imageView.context))
            .into(imageView)
}

@BindingAdapter("rating")
fun setRating(textView: TextView, rating: Double) {
    textView.text = rating.toString()
}
