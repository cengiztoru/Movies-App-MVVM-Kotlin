package com.cengiztoru.movies_simplifiedcoding.ui.movies_fragment

import android.view.View
import com.cengiztoru.movies_simplifiedcoding.data.models.Movie


/**     Code With 💗
 * Created by Cengiz TORU
 * cengiztoru@gmail.com
 */

interface IMoviesClickListener {
    fun itemClicked(view: View, movie: Movie)
}