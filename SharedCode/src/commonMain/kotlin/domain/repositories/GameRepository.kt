package com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories

import com.pandiandcode.mpp.cardsagainsthumanity.data.Result
import com.pandiandcode.mpp.cardsagainsthumanity.data.datasource.GameDataSource
import com.pandiandcode.mpp.cardsagainsthumanity.data.datasource.GameDataSourceImpl
import com.pandiandcode.mpp.cardsagainsthumanity.data.mappers.toData
import com.pandiandcode.mpp.cardsagainsthumanity.domain.data.Game
import com.pandiandcode.mpp.cardsagainsthumanity.domain.data.Player
import com.pandiandcode.mpp.cardsagainsthumanity.domain.mappers.toDomain

class GameRepository(private val dataSource: GameDataSource = GameDataSourceImpl()) {
    suspend fun put(game: Game): Result<Game> = dataSource.put(game.toData()).map {
        it.toDomain()
    }

    suspend fun putPlayer(gameId: String, player: Player): Result<Player> =
        dataSource.putPlayer(gameId, player.toData()).map { it.toDomain() }
}

