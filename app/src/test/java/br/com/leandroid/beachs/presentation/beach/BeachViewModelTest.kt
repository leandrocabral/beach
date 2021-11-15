package br.com.leandroid.beachs.presentation.beach

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.leandroid.beachs.presentation.CoroutineTestRule
import br.com.leandroid.core.Resource
import br.com.leandroid.data.network.funds.repository.BeachRepository
import br.com.leandroid.domain.model.BeachDomain
import br.com.leandroid.domain.usecase.BeachUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BeachViewModelTest {

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    private lateinit var viewModel: BeachViewModel

    private var beachUseCase =  mockk<BeachUseCase>()

    private var beachsObserverMock =  mockk<Observer<Resource<List<BeachDomain>>>>(relaxed = true)

    @Before
    fun setup() {
        viewModel = BeachViewModel(beachUseCase)
    }

    @Test
    fun `when view model fetch data then it should call repository, return success`() {
        val beachsList = listOf(
            BeachDomain("Praia1", "Descrição da praia")
        )

        coEvery { beachUseCase.getBeachs() } returns beachsList

        viewModel.getBeachs()

        coVerify {
            beachUseCase.getBeachs()
        }
    }

    @Test
    fun `when getBeach then set , return success`() {
        val beachsList = listOf(
            BeachDomain("Praia1", "Descrição da praia")
        )

        coEvery { beachUseCase.getBeachs() } returns beachsList

        viewModel.getBeachs()

        viewModel.beachs.observeForever(beachsObserverMock)

        coVerify{
            beachsObserverMock.onChanged(viewModel.beachs.value)
        }
    }
}
