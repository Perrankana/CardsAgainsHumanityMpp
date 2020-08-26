package com.pandiandcode.mpp.cardsagainsthumanity.domain.usecases

import com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories.WhiteDeckRepository

class DoGetWhiteDeck(private val whiteDeckRepository: WhiteDeckRepository) {
    suspend operator fun invoke(): String {
        return whiteDeckRepository.get().map {
            it.description
        }.toString()
    }
}