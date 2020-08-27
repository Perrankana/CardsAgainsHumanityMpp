package com.pandiandcode.mpp.cardsagainsthumanity.data.datasource

import com.pandiandcode.mpp.cardsagainsthumanity.data.Result
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.BlackDeckApi
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.BlackDeckApiImpl
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.WhiteDeckApi
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.WhiteDeckApiImpl
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.BlackCardApiData
import com.pandiandcode.mpp.cardsagainsthumanity.data.api.apidata.WhiteCardApiData

interface BlackDeckDataSource {
    suspend fun get(): Result<List<BlackCardApiData>>
}

class BlackDeckDataSourceImpl(
    private val api: BlackDeckApi = BlackDeckApiImpl()
) : BlackDeckDataSource {

    override suspend fun get(): Result<List<BlackCardApiData>> = try {
        Result.Success(api.get())
    } catch (e: Exception) {
        Result.Failed(e)
    }

}