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