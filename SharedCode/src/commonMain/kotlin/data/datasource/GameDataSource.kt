package com.pandiandcode.mpp.cardsagainsthumanity.data.datasource

import com.pandiandcode.mpp.cardsagainsthumanity.data.Result
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.GameApi
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.GameApiImpl
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.WhiteDeckApi
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.WhiteDeckApiImpl
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.GameApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.PlayersApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.WhiteCardApiData
import com.pandiandcode.mpp.cardsagainsthumanity.domain.data.Game
import com.pandiandcode.mpp.cardsagainsthumanity.domain.data.Player

interface GameDataSource {
    suspend fun put(game: GameApiData): Result<GameApiData>
    suspend fun putPlayer(gameId: String, player: PlayersApiData): Result<PlayersApiData>
}

class GameDataSourceImpl(
    private val api: GameApi = GameApiImpl()
) : GameDataSource {

    override suspend fun put(game: GameApiData): Result<GameApiData> = try {
        Result.Success(api.post(game))
    } catch (e: Exception) {
        println(e)
        Result.Failed(e)
    }

    override suspend fun putPlayer(gameId: String, player: PlayersApiData): Result<PlayersApiData> = try {
        Result.Success(api.postPlayer(gameId, player))
    } catch (e: Exception) {
        println(e)
        Result.Failed(e)
    }


}