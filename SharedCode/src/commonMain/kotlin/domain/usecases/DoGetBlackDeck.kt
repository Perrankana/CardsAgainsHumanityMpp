package com.pandiandcode.mpp.cardsagainsthumanity.domain.usecases

import com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories.BlackDeckRepository

class DoGetBlackDeck(
    private val repository: BlackDeckRepository = BlackDeckRepository()
) {
    suspend operator fun invoke(): String {
        return repository.get().map {
            it.description
        }.toString()
    }
}