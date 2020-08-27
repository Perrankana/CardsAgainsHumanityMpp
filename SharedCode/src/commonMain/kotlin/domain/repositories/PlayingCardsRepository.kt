package com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories

import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.PlayingCardsApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.datasource.PlayingCardsDataSource
import com.pandiandcode.mpp.cardsagainsthumanity.data.datasource.PlayingCardsDataSourceImpl


class PlayingCardsRepository(private val dataSource: PlayingCardsDataSource = PlayingCardsDataSourceImpl()) {
    suspend fun getPlayingCards() : List<PlayingCardsApiData> = dataSource.getPlayingCards().fold({
        it
    },{
        emptyList()
    })
}