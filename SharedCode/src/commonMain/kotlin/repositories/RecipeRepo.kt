package com.pandiandcode.mpp.cardsagainsthumanity.repositories

import com.pandiandcode.mpp.cardsagainsthumanity.data.api.RecipeApi


class RecipeRepo(private val api: RecipeApi) {
    suspend fun getRecipe() : String {
        return api.getRecipe()
    }
}