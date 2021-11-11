package br.com.leandroid.beachs.presentation.beach

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.leandroid.core.BaseViewModel
import br.com.leandroid.core.Resource
import br.com.leandroid.domain.model.BeachDomain
import br.com.leandroid.domain.usecase.BeachUseCase
import kotlinx.coroutines.launch

class BeachViewModel(private val useCase: BeachUseCase) : BaseViewModel()  {

    val beachs = MutableLiveData<Resource<List<BeachDomain>>>()

    fun getBeachs() {
        viewModelScope.launch {
            with(beachs) {
                loading(true)
                try {
                    success(useCase.getBeachs())
                } catch (e: Exception) {
                    error(e)
                } finally {
                    loading(false)
                }
            }
        }
    }
}