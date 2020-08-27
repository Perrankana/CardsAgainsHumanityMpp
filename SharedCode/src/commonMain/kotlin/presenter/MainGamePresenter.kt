package com.pandiandcode.mpp.cardsagainsthumanity.presenter

import com.pandiandcode.mpp.cardsagainsthumanity.dispatchers.Background
import com.pandiandcode.mpp.cardsagainsthumanity.dispatchers.Main
import com.pandiandcode.mpp.cardsagainsthumanity.domain.data.Game
import com.pandiandcode.mpp.cardsagainsthumanity.domain.data.Player
import com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories.BlackDeckRepository
import com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories.PlayingCardsRepository
import com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories.WhiteDeckRepository
import com.pandiandcode.mpp.cardsagainsthumanity.domain.usecases.DoGetBlackDeck
import com.pandiandcode.mpp.cardsagainsthumanity.domain.usecases.DoGetPlayingCards
import com.pandiandcode.mpp.cardsagainsthumanity.domain.usecases.DoGetWhiteDeck
import com.pandiandcode.mpp.cardsagainsthumanity.domain.usecases.DoStartGame
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

    fun start() {
        GlobalScope.apply {
            launch(Background) {
                val json = startGame(
                    "Hola Juego"
                )
                withContext(Main) {
                    view?.showState(json.toString())
                }
            }
        }
    }
}

interface View {
    fun showState(json: String)
}