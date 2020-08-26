package com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories

import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.PlayingCardsApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.datasource.PlayingCardsDataSource
import com.pandiandcode.mpp.cardsagainsthumanity.data.datasource.PlayingCardsDataSourceImpl


class PlayingCardsRepository {
    private var api: PlayingCardsDataSource

    constructor(api: PlayingCardsDataSource) {
        this.api = api
    }

    constructor(){
        this.api = PlayingCardsDataSourceImpl()
    }

    suspend fun getRecipe() : List<PlayingCardsApiData> {
        return api.getPlayingCards().fold({
            it
        },{
            emptyList()
        })
    }
}