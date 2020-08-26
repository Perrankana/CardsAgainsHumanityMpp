package com.pandiandcode.mpp.cardsagainsthumanity.domain.repositories

import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.WhiteCardApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.datasource.WhiteDeckDataSource
import com.pandiandcode.mpp.cardsagainsthumanity.data.datasource.WhiteDeckDataSourceImpl


class WhiteDeckRepository {
    private var dataSource: WhiteDeckDataSource

    constructor(api: WhiteDeckDataSource) {
        this.dataSource = api
    }

    constructor(){
        this.dataSource = WhiteDeckDataSourceImpl()
    }

    suspend fun get() : List<WhiteCardApiData> {
        return dataSource.get().fold({
            it
        },{
            print(it)
            emptyList()
        })
    }
}