package com.cengiztoru.movies_simplifiedcoding.ui.movies_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cengiztoru.movies_simplifiedcoding.data.repositories.MoviesRepository


/**     Code With 💗
 * Created by Cengiz TORU
 * cengiztoru@gmail.com
 */

@Suppress("UNCHECKED_CAST")
class MoviesViewModelFactory(

    private val repository: MoviesRepository

) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(repository) as T
    }
}