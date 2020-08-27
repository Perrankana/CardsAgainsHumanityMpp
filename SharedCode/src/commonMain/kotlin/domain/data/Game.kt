package com.pandiandcode.mpp.cardsagainsthumanity.domain.data

data class Game(val id: String? = null, val name: String, val code: String, val players: List<Player> = emptyList())