package com.cengiztoru.movies_simplifiedcoding

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cengiztoru.movies_simplifiedcoding.data.network.MoviesApi
import com.cengiztoru.movies_simplifiedcoding.data.repositories.MoviesRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //checking retrofit
        val repository = MoviesRepository(MoviesApi())
        GlobalScope.launch(Dispatchers.Main) {
            val movies = repository.getMovies()
            tv.text = movies.toString()
            Toast.makeText(this@MainActivity, movies.toString() + "", Toast.LENGTH_SHORT).show()
        }
    }
}