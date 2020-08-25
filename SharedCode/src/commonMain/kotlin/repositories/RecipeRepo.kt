package com.pandiandcode.mpp.cardsagainsthumanity.repositories

import com.pandiandcode.mpp.cardsagainsthumanity.data.api.CahApi
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.PlayingCardsApiData


class RecipeRepo(private val api: CahApi) {
    suspend fun getRecipe() : List<PlayingCardsApiData> {
        return api.getRecipe()
    }
}