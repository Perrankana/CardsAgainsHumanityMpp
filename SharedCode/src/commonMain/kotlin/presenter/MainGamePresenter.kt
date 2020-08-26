package com.pandiandcode.mpp.cardsagainsthumanity.presenter

import com.pandiandcode.mpp.cardsagainsthumanity.dispatchers.Background
import com.pandiandcode.mpp.cardsagainsthumanity.dispatchers.Main
import com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories.PlayingCardsRepository
import com.pandiandcode.mpp.cardsagainsthumanity.domain.usecases.DoGetPlayingCards
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainGamePresenter {

    private var getPlayingCards: DoGetPlayingCards

    constructor(getPlayingCards: DoGetPlayingCards) {
        this.getPlayingCards = getPlayingCards
    }
    constructor(){
        this.getPlayingCards = DoGetPlayingCards(PlayingCardsRepository())
    }

    var view: View? = null

    fun start() {
        GlobalScope.apply {
            launch(Background) {
                val json = getPlayingCards()
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