package com.pandiandcode.mpp.cardsagainsthumanity.data

sealed class Result<T> {
    data class Success<T>(val value: T) : Result<T>()
    data class Failed<T>(val exception: Exception) : Result<T>()

    inline fun <R> fold(success: (T) -> R, failed: (Exception) -> R): R = when (this) {
        is Success -> success(value)
        is Failed -> failed(exception)
    }

    inline fun <R> map(function: (T) -> R): Result<R> = fold({
        Success(function(it))
    }, {
        Failed(it)
    })

}


