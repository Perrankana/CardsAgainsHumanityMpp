package com.pandiandcode.mpp.cardsagainsthumanity.data.api


import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.BlackCardApiData
import io.ktor.client.request.*

interface BlackDeckApi {
    suspend fun get(): List<BlackCardApiData>
}

class BlackDeckApiImpl : BlackDeckApi, Api() {
    override suspend fun get(): List<BlackCardApiData> =
        client.get {
            url("${address}black-deck")
        }

}

