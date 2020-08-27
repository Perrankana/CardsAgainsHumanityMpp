package com.pandiandcode.mpp.cardsagainsthumanity.domain.usecases

import com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories.PlayingCardsRepository

class DoGetPlayingCards(
    private val playingCardsRepository: PlayingCardsRepository = PlayingCardsRepository()
) {
    suspend operator fun invoke(): String {
        return playingCardsRepository.getPlayingCards().map {
            it._id
        }.toString()
    }
}