package com.cengiztoru.movies_simplifiedcoding.ui.movies_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cengiztoru.movies_simplifiedcoding.R
import com.cengiztoru.movies_simplifiedcoding.data.api.MoviesApi
import com.cengiztoru.movies_simplifiedcoding.data.models.Movie
import com.cengiztoru.movies_simplifiedcoding.data.repositories.MoviesRepository
import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment : Fragment(), IMoviesClickListener {
    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = MoviesApi()
        val repository = MoviesRepository(api)
        factory = MoviesViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(MoviesViewModel::class.java)
        viewModel.getMovies()
        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            recyclerview_movies.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = MoviesAdapter(movies, this)
            }
        })

    }

    override fun itemClicked(view: View, movie: Movie) {
        when (view.id) {
            R.id.button_book -> {
                Toast.makeText(requireContext(), "Book Button Clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.layout_like -> {
                Toast.makeText(requireContext(), "Like Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

}