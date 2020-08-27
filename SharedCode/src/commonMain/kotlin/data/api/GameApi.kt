package com.pandiandcode.mpp.cardsagainsthumanity.data.api


import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.GameApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.PlayersApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.WhiteCardApiData
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Job

interface GameApi {
    suspend fun post(game: GameApiData): GameApiData

    suspend fun postPlayer(gameId: String, playersApiData: PlayersApiData): PlayersApiData
}

class GameApiImpl : GameApi, Api() {
    override suspend fun post(game: GameApiData): GameApiData =
        client.post {
            url("${address}game")
            contentType(
                ContentType.parse("application/json")
            )
            body = game
        }

    override suspend fun postPlayer(gameId: String, playersApiData: PlayersApiData): PlayersApiData =
        client.post {
            url("${address}game/$gameId/players")
            contentType(
                ContentType.parse("application/json")
            )
            body = playersApiData
        }
}

