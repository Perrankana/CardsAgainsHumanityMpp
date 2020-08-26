package com.pandiandcode.mpp.cardsagainsthumanity.data.api

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

abstract class Api {
     protected val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                this.ignoreUnknownKeys = true
            })
        }
        defaultRequest {
            header(API_KEY, API_KEY_VALUE)
        }
    }

    protected var address = Url(BASE_URL)

    companion object {
        const val BASE_URL = "https://carsagainstperra-d8ea.restdb.io/rest/"
        const val API_KEY = "x-apikey"
        const val API_KEY_VALUE = "0ac361fd985eea54cd349b5bcd0640a7890ba"
    }

}