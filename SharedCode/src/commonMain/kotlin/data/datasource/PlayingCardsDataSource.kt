package com.pandiandcode.mpp.cardsagainsthumanity.data.datasource

import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.NewPlayingCardsApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.PlayingCardsApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.Result

interface PlayingCardsDataSource {
    suspend fun getPlayingCards(): Result<List<PlayingCardsApiData>>
    suspend fun putPlayingCards(cards: NewPlayingCardsApiData): Result<Unit>
    suspend fun clearCards(): Result<Unit>
}