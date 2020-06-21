package com.cengiztoru.movies_simplifiedcoding


/**     Code With 💗
 * Created by Cengiz TORU
 * cengiztoru@gmail.com
 */

class MoviesRepository(
    private val api: MoviesApi
) : SafeApiRequest() {
    suspend fun getMovies() = apiRequest { api.getMovies() }
}