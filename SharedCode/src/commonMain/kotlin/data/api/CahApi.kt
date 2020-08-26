package com.pandiandcode.mpp.cardsagainsthumanity.data.api


import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.NewPlayingCardsApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.PlayingCardsApiData
import io.ktor.client.request.*

interface CahApi {
    suspend fun getPlayingCards(): List<PlayingCardsApiData>

    suspend fun putPlayingCards(playingCards: NewPlayingCardsApiData)

    suspend fun deleteCard(id: String)
}

class CahApiImpl : CahApi, Api() {

    override suspend fun getPlayingCards(): List<PlayingCardsApiData> =
        client.get {
            url("$address/playingcards")
        }

    override suspend fun putPlayingCards(playingCards: NewPlayingCardsApiData) =
        client.put<Unit> {
            url("$address/playingcards")
            body = playingCards
        }

    override suspend fun deleteCard(id: String) =
        client.delete<Unit> {
            url("$address/playingcards/id=$id")
        }
}

