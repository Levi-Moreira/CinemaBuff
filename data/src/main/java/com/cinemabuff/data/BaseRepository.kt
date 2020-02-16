package com.cinemabuff.data

import com.cinemabuff.data.network.NetworkResult
import timber.log.Timber
import java.io.IOException


open class BaseRepository {
    suspend fun <T : Any> call(call: suspend () -> T, errorMessage: String): T? {
        val networkResult: NetworkResult<T> = apiCall(call, errorMessage)
        var callData: T? = null

        when (networkResult) {
            is NetworkResult.Success ->
                callData = networkResult.data
            is NetworkResult.Error -> {
                Timber.d("$errorMessage & Exception - ${networkResult.exception}")
            }
        }
        return callData
    }

    private suspend fun <T : Any> apiCall(
        call: suspend () -> T,
        errorMessage: String
    ): NetworkResult<T> {
        return try {
            val response = call.invoke()
            NetworkResult.Success(response)
        } catch (e: Exception) {
            Timber.e(e)
            NetworkResult.Error(IOException("Error Occurred: ERROR - $errorMessage"))
        }
    }
}