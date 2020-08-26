package com.pandiandcode.mpp.cardsagainsthumanity.presenter

import com.pandiandcode.mpp.cardsagainsthumanity.dispatchers.Background
import com.pandiandcode.mpp.cardsagainsthumanity.dispatchers.Main
import com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories.PlayingCardsRepository
import com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories.WhiteDeckRepository
import com.pandiandcode.mpp.cardsagainsthumanity.domain.usecases.DoGetPlayingCards
import com.pandiandcode.mpp.cardsagainsthumanity.domain.usecases.DoGetWhiteDeck
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainGamePresenter {

    private var getPlayingCards: DoGetPlayingCards
    private var getWhiteDeck: DoGetWhiteDeck

    constructor(getPlayingCards: DoGetPlayingCards, getWhiteDeck: DoGetWhiteDeck) {
        this.getPlayingCards = getPlayingCards
        this.getWhiteDeck = getWhiteDeck
    }
    constructor(){
        this.getPlayingCards = DoGetPlayingCards(PlayingCardsRepository())
        this.getWhiteDeck = DoGetWhiteDeck(WhiteDeckRepository())
    }

    var view: View? = null

    fun start() {
        GlobalScope.apply {
            launch(Background) {
                val json = getWhiteDeck()
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