package br.com.leandroid.data.network.funds.repository

import br.com.leandroid.data.network.funds.entity.BeachEntity

interface BeachRepository {
    suspend fun getBeach():  List<BeachEntity>?
}