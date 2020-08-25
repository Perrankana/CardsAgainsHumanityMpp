package com.pandiandcode.mpp.cardsagainsthumanity.data.api


import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.Serializable

class CahApi {
    private val client = HttpClient {
        install(JsonFeature){
            serializer = KotlinxSerializer()
        }
        defaultRequest {
            header(API_KEY, API_KEY_VALUE)
        }
    }

    private var address = Url(BASE_URL)

    suspend fun getRecipe(): List<PlayingCardsApiData> {

        return client.get {
            url("$address/playingcards")
        }
    }

    private companion object {
        const val BASE_URL = "https://carsagainstperra-d8ea.restdb.io/rest/"
        const val API_KEY = "x-apikey"
        const val API_KEY_VALUE = "0ac361fd985eea54cd349b5bcd0640a7890ba"
    }
}

@Serializable
data class PlayingCardsApiData(val _id: String, val cards: List<CardApiData>)

@Serializable
data class NewPlayingCardsApiData(val cards: List<CardApiData>)

@Serializable
data class CardApiData(val description: String)

