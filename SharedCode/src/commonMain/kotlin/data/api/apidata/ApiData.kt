package com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata

import kotlinx.serialization.Serializable


@Serializable
data class PlayingCardsApiData(val _id: String, val cards: List<CardApiData>)

@Serializable
data class NewPlayingCardsApiData(val cards: List<CardApiData>)

@Serializable
data class CardApiData(val description: String)

@Serializable
data class WhiteCardApiData(val id: Int, val description: String)

@Serializable
data class BlackCardApiData(val id: Int, val description: String, val draw: Int, val pick: Int)

@Serializable
data class GameApiData(val name: String, val code: String, val players: List<PlayersApiData>, val _id: String? = null)

@Serializable
data class PlayersApiData(val name: String, val score: Int, val _id: String? = null)