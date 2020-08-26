package com.pandiandcode.mpp.cardsagainsthumanity.data.api


import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.WhiteCardApiData
import io.ktor.client.request.*

interface WhiteDeckApi {
    suspend fun get(): List<WhiteCardApiData>
}

class WhiteDeckApiImpl : WhiteDeckApi, Api() {
    override suspend fun get(): List<WhiteCardApiData> =
        client.get {
            url("${address}white-deck")
        }

}

