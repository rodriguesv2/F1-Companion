package br.com.rubensrodrigues.presentation.ui.pages.grandprix

import br.com.rubensrodrigues.domain.entities.GrandPrix
import br.com.rubensrodrigues.domain.usecases.GetGrandPrixUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GrandPrixViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: GrandPrixViewModel
    private val useCase: GetGrandPrixUseCase = mockk()

    private val grandPrixList = List(10) {
        GrandPrix(
            day = "20",
            month = "September",
            round = "16",
            location = "Belgium",
            name = "Spa-Francorchamps Grand Prix",
        )
    }

    @Before
    fun setUp() {
        viewModel = GrandPrixViewModel(useCase)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `WHEN viewModel is initialized THEN fetchData() is called`() = runTest {
        //Arrange
        coEvery { useCase(2024) } returns grandPrixList

        //Act

        //Assert
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}