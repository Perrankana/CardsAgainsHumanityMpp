package com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories

import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.WhiteCardApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.datasource.WhiteDeckDataSource
import com.pandiandcode.mpp.cardsagainsthumanity.data.datasource.WhiteDeckDataSourceImpl


class WhiteDeckRepository(
    private val dataSource: WhiteDeckDataSource = WhiteDeckDataSourceImpl()
) {

    suspend fun get(): List<WhiteCardApiData> {
        return dataSource.get().fold({
            it
        }, {
            print(it)
            emptyList()
        })
    }
}