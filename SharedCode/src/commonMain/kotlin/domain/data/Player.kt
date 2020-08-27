package com.pandiandcode.mpp.cardsagainsthumanity.domain.data

data class Player(val name: String, val score: Int, val host: Boolean, val _id: String? = null)

fun hostPlayer(name: String) = Player(
    name = name,
    score = 0,
    host = true
)