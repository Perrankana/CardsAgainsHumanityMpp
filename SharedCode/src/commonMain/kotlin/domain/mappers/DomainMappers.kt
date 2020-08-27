package com.pandiandcode.mpp.cardsagainsthumanity.domain.mappers

import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.GameApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.PlayersApiData
import com.pandiandcode.mpp.cardsagainsthumanity.domain.data.Game
import com.pandiandcode.mpp.cardsagainsthumanity.domain.data.Player

fun GameApiData.toDomain(): Game = Game(_id, name, code, players.toDomain())

fun List<PlayersApiData>.toDomain(): List<Player> = map {
    it.toDomain()
}

fun PlayersApiData.toDomain(): Player = Player(
    name = name,
    score = score,
    host = host,
    _id = _id
)