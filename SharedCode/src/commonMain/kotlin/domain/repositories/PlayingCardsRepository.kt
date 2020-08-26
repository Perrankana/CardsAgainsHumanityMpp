package com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories

import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.PlayingCardsApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.datasource.PlayingCardsDataSource
import com.pandiandcode.mpp.cardsagainsthumanity.data.datasource.PlayingCardsDataSourceImpl


class PlayingCardsRepository {
    private var dataSource: PlayingCardsDataSource

    constructor(api: PlayingCardsDataSource) {
        this.dataSource = api
    }

    constructor(){
        this.dataSource = PlayingCardsDataSourceImpl()
    }

    suspend fun getPlayingCards() : List<PlayingCardsApiData> = dataSource.getPlayingCards().fold({
        it
    },{
        emptyList()
    })
}