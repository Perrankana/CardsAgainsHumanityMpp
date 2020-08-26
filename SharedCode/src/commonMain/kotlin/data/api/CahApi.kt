package com.pandiandcode.mpp.cardsagainsthumanity.data.api


import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.NewPlayingCardsApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.PlayingCardsApiData
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

interface CahApi {
    suspend fun getPlayingCards(): List<PlayingCardsApiData>

    suspend fun putPlayingCards(playingCards: NewPlayingCardsApiData)

    suspend fun deleteCard(id: String)
}

class CahApiImpl : CahApi {
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
        defaultRequest {
            header(API_KEY, API_KEY_VALUE)
        }
    }

    private var address = Url(BASE_URL)

    private companion object {
        const val BASE_URL = "https://carsagainstperra-d8ea.restdb.io/rest/"
        const val API_KEY = "x-apikey"
        const val API_KEY_VALUE = "0ac361fd985eea54cd349b5bcd0640a7890ba"
    }

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

