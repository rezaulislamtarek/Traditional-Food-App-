package com.diatomicsoft.culturalfoods.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("drawableImage")
fun setDrawableImage(view: ImageView, image: Int){
    view.setImageResource(image)
}