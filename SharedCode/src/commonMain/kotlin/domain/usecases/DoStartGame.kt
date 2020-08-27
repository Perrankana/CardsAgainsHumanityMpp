package com.pandiandcode.mpp.cardsagainsthumanity.domain.usecases

import com.pandiandcode.mpp.cardsagainsthumanity.data.Result
import com.pandiandcode.mpp.cardsagainsthumanity.domain.CodeProvider
import com.pandiandcode.mpp.cardsagainsthumanity.domain.CodeProviderImpl
import com.pandiandcode.mpp.cardsagainsthumanity.domain.data.Game
import com.pandiandcode.mpp.cardsagainsthumanity.domain.data.Player
import com.pandiandcode.mpp.cardsagainsthumanity.domain.data.hostPlayer
import com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories.GameRepository

class DoStartGame(
    private val repository: GameRepository = GameRepository(),
    private val codeProvider: CodeProvider = CodeProviderImpl()
) {
    suspend operator fun invoke(gameName: String, playerName: String): Result<Game> {
        return repository.put(
            Game(
                name = gameName,
                code = codeProvider.generateCode()
            )
        ).map { game ->
            repository.putPlayer(game.id!!, hostPlayer(name = playerName)).fold({
                game.copy(players = game.players.toMutableList().apply {
                    add(it)
                })
            }, {
                game
            })

        }
    }


}