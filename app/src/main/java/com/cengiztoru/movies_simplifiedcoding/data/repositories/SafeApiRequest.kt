package com.cengiztoru.movies_simplifiedcoding.data.repositories

import retrofit2.Response
import java.io.IOException


/**     Code With 💗
 * Created by Cengiz TORU
 * cengiztoru@gmail.com
 */

abstract class SafeApiRequest {

    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw ApiException(
                "ERROR in SAFE_API_REQUEST CLASS" + response.code().toString()
            )
        }
    }

}

class ApiException(message: String) : IOException(message)