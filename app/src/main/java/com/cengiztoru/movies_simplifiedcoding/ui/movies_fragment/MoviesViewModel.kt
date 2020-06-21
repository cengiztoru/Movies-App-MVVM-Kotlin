package com.cengiztoru.movies_simplifiedcoding.ui.movies_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cengiztoru.movies_simplifiedcoding.data.models.Movie
import com.cengiztoru.movies_simplifiedcoding.data.repositories.MoviesRepository

class MoviesViewModel(private val repository: MoviesRepository) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    suspend fun getMovies() {
        val movies = repository.getMovies()
        _movies.value = movies
    }

}