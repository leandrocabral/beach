package br.com.leandroid.data.network.funds.repository

import br.com.leandroid.data.network.funds.api.BeachApi
import br.com.leandroid.data.network.funds.entity.BeachEntity
import retrofit2.Retrofit

class BeachRepositoryImpl(private var retrofit: Retrofit) : BeachRepository {

    private val remoteBeach by lazy {
        retrofit.create(BeachApi::class.java)
    }

    override suspend fun getBeach(): List<BeachEntity>? {
        return remoteBeach.getBeach("").body()
    }
}