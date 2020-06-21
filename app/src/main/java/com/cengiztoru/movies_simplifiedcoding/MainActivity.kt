package com.cengiztoru.movies_simplifiedcoding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        //checking retrofit
//        val repository = MoviesRepository(MoviesApi())
//        GlobalScope.launch(Dispatchers.Main) {
//            val movies = repository.getMovies()
//            tv.text = movies.toString()
//            Toast.makeText(this@MainActivity, movies.toString() + "", Toast.LENGTH_SHORT).show()
//        }
    }
}