package com.cengiztoru.movies_simplifiedcoding.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


/**     Code With 💗
 * Created by Cengiz TORU
 * cengiztoru@gmail.com
 */

@BindingAdapter("loadImage")
fun loadImageFromUrl(view: ImageView, url: String) {
//    SOME OPERATIONS
//    if (!url.contains(BASE_URL)){
//        val origin = url
//        url = BASE_URL+origin
//    }
    Glide.with(view)
        .load(url)
        .into(view)
}