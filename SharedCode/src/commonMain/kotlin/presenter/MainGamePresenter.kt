package com.pandiandcode.mpp.cardsagainsthumanity.presenter

import com.pandiandcode.mpp.cardsagainsthumanity.dispatchers.Background
import com.pandiandcode.mpp.cardsagainsthumanity.dispatchers.Main
import com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories.BlackDeckRepository
import com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories.PlayingCardsRepository
import com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories.WhiteDeckRepository
import com.pandiandcode.mpp.cardsagainsthumanity.domain.usecases.DoGetBlackDeck
import com.pandiandcode.mpp.cardsagainsthumanity.domain.usecases.DoGetPlayingCards
import com.pandiandcode.mpp.cardsagainsthumanity.domain.usecases.DoGetWhiteDeck
import com.pandiandcode.mpp.cardsagainsthumanity.domain.usecases.DoStartGame
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainGamePresenter {

    private var getPlayingCards: DoGetPlayingCards
    private var getWhiteDeck: DoGetWhiteDeck
    private var getBlackDeck: DoGetBlackDeck
    private var startGame: DoStartGame

    constructor(
        getPlayingCards: DoGetPlayingCards,
        getWhiteDeck: DoGetWhiteDeck,
        getBlackDeck: DoGetBlackDeck,
        startGame: DoStartGame
    ) {
        this.getPlayingCards = getPlayingCards
        this.getWhiteDeck = getWhiteDeck
        this.getBlackDeck = getBlackDeck
        this.startGame = startGame
    }

    constructor() {
        this.getPlayingCards = DoGetPlayingCards(PlayingCardsRepository())
        this.getWhiteDeck = DoGetWhiteDeck(WhiteDeckRepository())
        this.getBlackDeck = DoGetBlackDeck(BlackDeckRepository())
        this.startGame = DoStartGame()
    }

    var view: View? = null

    fun start(gameName: String, playerName: String) {
        GlobalScope.apply {
            launch(Main) {
                withContext(Background){
                    startGame(gameName, playerName)
                }.fold({
                    view?.showState(it.toString())
                },{
                    view?.showState(it.stackTraceToString())
                })
            }
        }
    }
}

interface View {
    fun showState(json: String)
}