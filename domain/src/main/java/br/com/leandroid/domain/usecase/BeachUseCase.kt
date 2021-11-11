package br.com.leandroid.domain.usecase

import br.com.leandroid.data.network.funds.repository.BeachRepository
import br.com.leandroid.domain.model.BeachDomain

class BeachUseCase(private val remoteRepository: BeachRepository) {

    suspend fun getBeachs(): List<BeachDomain> {
        return BeachDomain.convertToDomainList(remoteRepository.getBeach())
    }
}