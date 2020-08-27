package com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories

import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.BlackCardApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.datasource.BlackDeckDataSource
import com.pandiandcode.mpp.cardsagainsthumanity.data.datasource.BlackDeckDataSourceImpl


class BlackDeckRepository(
    private val dataSource: BlackDeckDataSource = BlackDeckDataSourceImpl()
) {

    suspend fun get(): List<BlackCardApiData> {
        return dataSource.get().fold({
            it
        }, {
            print(it)
            emptyList()
        })
    }
}