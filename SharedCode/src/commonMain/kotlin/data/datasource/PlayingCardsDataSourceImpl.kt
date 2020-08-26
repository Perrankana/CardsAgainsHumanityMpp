package com.pandiandcode.mpp.cardsagainsthumanity.data.datasource

import com.pandiandcode.mpp.cardsagainsthumanity.data.Result
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.CahApi
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.CahApiImpl
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.NewPlayingCardsApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.PlayingCardsApiData

class PlayingCardsDataSourceImpl : PlayingCardsDataSource {
    private var api: CahApi

    constructor(api: CahApi) {
        this.api = api
    }

    constructor() {
        this.api = CahApiImpl()
    }

    override suspend fun getPlayingCards(): Result<List<PlayingCardsApiData>> =
        try {
            Result.Success(api.getPlayingCards())
        } catch (e: Exception) {
            Result.Failed(e)
        }

    override suspend fun putPlayingCards(cards: NewPlayingCardsApiData): Result<Unit> =
        try {
            Result.Success(api.putPlayingCards(cards))
        } catch (e: Exception) {
            Result.Failed(e)
        }

    override suspend fun clearCards(): Result<Unit> = when (val result = getPlayingCards()) {
        is Result.Success -> {
            val ids = result.value.map { it._id }
            clearAllCards(ids)
        }
        is Result.Failed -> Result.Failed(result.exception)
    }

    private suspend fun clearAllCards(ids: List<String>): Result<Unit> {
        var failed = false
        var exception: Exception? = null
        ids.forEach { id ->
            val result = deleteCard(id)
            if (result is Result.Failed) {
                exception = result.exception
                failed = true
                return@forEach
            }
        }
        return if (failed) {
            Result.Failed(exception!!)
        } else {
            Result.Success(Unit)
        }
    }

    private suspend fun deleteCard(id: String): Result<Unit> = try {
        Result.Success(api.deleteCard(id))
    } catch (e: Exception) {
        Result.Failed(e)
    }

}