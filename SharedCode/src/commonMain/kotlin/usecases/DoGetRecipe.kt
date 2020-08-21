package com.pandiandcode.mpp.cardsagainsthumanity.usecases

import com.pandiandcode.mpp.cardsagainsthumanity.repositories.RecipeRepo

class DoGetRecipe(private val recipeRepo: RecipeRepo) {
    suspend fun getRecipe(): String {
        return recipeRepo.getRecipe()
    }
}