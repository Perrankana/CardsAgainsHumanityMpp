package com.pandiandcode.mpp.cardsagainsthumanity.data.mappers

import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.GameApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.PlayersApiData
import com.pandiandcode.mpp.cardsagainsthumanity.domain.data.Game
import com.pandiandcode.mpp.cardsagainsthumanity.domain.data.Player

fun Game.toData(): GameApiData = GameApiData(
    _id = id,
    name = name,
    code = code,
    players = players.toData()
)

fun List<Player>.toData(): List<PlayersApiData> = map {
    it.toData()
}

fun Player.toData(): PlayersApiData = PlayersApiData(
    name = name,
    score = score,
    host = host,
    _id = _id
)
