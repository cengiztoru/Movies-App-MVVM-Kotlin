package com.cengiztoru.movies_simplifiedcoding.ui.movies_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cengiztoru.movies_simplifiedcoding.data.models.Movie
import com.cengiztoru.movies_simplifiedcoding.data.repositories.MoviesRepository
import com.cengiztoru.movies_simplifiedcoding.util.Coroutines
import kotlinx.coroutines.Job

class MoviesViewModel(private val repository: MoviesRepository) : ViewModel() {

    private lateinit var job: Job

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

//    suspend fun getMovies() {
//        val movies = repository.getMovies()
//        _movies.value = movies
//    }

    fun getMovies() {
        job = Coroutines.ioThenMain(
            { repository.getMovies() },
            { _movies.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()

        if (::job.isInitialized) job.cancel()

    }

}