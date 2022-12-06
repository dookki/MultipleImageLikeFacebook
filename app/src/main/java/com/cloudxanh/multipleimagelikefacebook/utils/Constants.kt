package com.cloudxanh.multipleimagelikefacebook.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.imageview.ShapeableImageView


/**
 * @Created by Sonpxp on 12/6/2022.
 * @Website: Cloudxanh.com
 * @Email: sonpxp@gmail.com
 */
object Constants {

}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun ImageView.loadImage(url: String, options: RequestOptions.() -> RequestOptions) {
    Glide.with(this.context).load(url).apply(RequestOptions().options()).into(this)
}

fun ImageView.loadImage(resource: Int, options: RequestOptions.() -> RequestOptions) {
    Glide.with(this.context).load(resource).apply(RequestOptions().options()).into(this)
}

fun ImageView.loadImage(url: String) {
    Glide.with(this.context).load(url).into(this)
}

fun ImageView.loadImage(resource: Int) {
    Glide.with(this.context).load(resource).into(this)
}

fun ShapeableImageView.loadImage(url: String) {
    Glide.with(this.context).load(url).into(this)
}

fun ShapeableImageView.loadImage(url: Drawable) {
    Glide.with(this.context).load(url).into(this)
}
