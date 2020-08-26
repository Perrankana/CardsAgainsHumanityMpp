package com.pandiandcode.mpp.cardsagainsthumanity.domain.usecases

import com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories.PlayingCardsRepository

class DoGetPlayingCards(private val playingCardsRepository: PlayingCardsRepository) {
    suspend operator fun invoke(): String {
        return playingCardsRepository.getRecipe().map {
            it._id
        }.toString()
    }
}