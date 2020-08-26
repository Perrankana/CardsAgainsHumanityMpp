package com.pandiandcode.mpp.cardsagainsthumanity.data.datasource

import com.pandiandcode.mpp.cardsagainsthumanity.data.Result
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.WhiteDeckApi
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.WhiteDeckApiImpl
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.WhiteCardApiData

interface WhiteDeckDataSource {
    suspend fun get(): Result<List<WhiteCardApiData>>
}

class WhiteDeckDataSourceImpl: WhiteDeckDataSource{
    private var api: WhiteDeckApi

    constructor(api: WhiteDeckApi) {
        this.api = api
    }

    constructor() {
        api = WhiteDeckApiImpl()
    }
    override suspend fun get(): Result<List<WhiteCardApiData>> = try {
        Result.Success(api.get())
    }catch (e: Exception){
        Result.Failed(e)
    }

}