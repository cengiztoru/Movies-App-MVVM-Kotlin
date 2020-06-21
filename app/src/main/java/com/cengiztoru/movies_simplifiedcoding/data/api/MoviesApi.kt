package com.cengiztoru.movies_simplifiedcoding.data.api

import com.cengiztoru.movies_simplifiedcoding.data.models.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


/**     Code With 💗
 * Created by Cengiz TORU
 * cengiztoru@gmail.com
 */
interface MoviesApi {

    @GET("movies")
    suspend fun getMovies(): Response<List<Movie>>

    companion object {
        operator fun invoke(): MoviesApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.simplifiedcoding.in/course-apis/recyclerview/")
                .build()
                .create(MoviesApi::class.java)
        }
    }
}