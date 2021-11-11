package br.com.leandroid.data.network.funds.api

import br.com.leandroid.data.network.funds.entity.BeachEntity
import br.com.leandroid.data.network.funds.entity.FundsEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BeachApi {

    @GET("local/beach")
    suspend fun getBeach(
        @Query("serializer") serializer: String
    ): Response<List<BeachEntity>>
}