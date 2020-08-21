package com.pandiandcode.mpp.cardsagainsthumanity.presenter

import com.pandiandcode.mpp.cardsagainsthumanity.data.api.RecipeApi
import com.pandiandcode.mpp.cardsagainsthumanity.dispatchers.Background
import com.pandiandcode.mpp.cardsagainsthumanity.dispatchers.Main
import com.pandiandcode.mpp.cardsagainsthumanity.repositories.RecipeRepo
import com.pandiandcode.mpp.cardsagainsthumanity.usecases.DoGetRecipe
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecipePresenter {

    private lateinit var getRecipe: DoGetRecipe

    constructor(getRecipe: DoGetRecipe) {
        this.getRecipe = getRecipe
    }
    constructor(){
        this.getRecipe = DoGetRecipe(RecipeRepo(RecipeApi()))
    }

    var view: View? = null

    fun start() {
        GlobalScope.apply {
            launch(Background) {
                val json = getRecipe.getRecipe()
                withContext(Main){
                    view?.showState(json)
                }
            }
        }
    }
}

interface View {
    fun showState(json: String)
}