package br.com.rubensrodrigues.presentation.ui.pages.grandprix

import br.com.rubensrodrigues.domain.entities.GrandPrix
import br.com.rubensrodrigues.domain.usecases.GetGrandPrixUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
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
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `GIVEN a GrandPrixViewModel WHEN fetchData is called THEN uiState is updated first with isLoading equals true and then with response data`() =
        runTest {
            //Arrange
            viewModel = GrandPrixViewModel(useCase)
            coEvery { useCase(2024) } coAnswers {
                delay(50)
                grandPrixList
            }

            val emittedStates = mutableListOf<GrandPrixUiState>()
            val job = launch {
                viewModel.uiState.toList(emittedStates)
            }

            //Act
            viewModel.fetchData()
            testDispatcher.scheduler.advanceUntilIdle()

            //Assert
            Assert.assertEquals(
                listOf(
                    GrandPrixUiState(),
                    GrandPrixUiState(isLoading = true),
                    GrandPrixUiState(
                        grandPrixList = grandPrixList,
                        isLoading = false,
                    )
                ),
                emittedStates
            )

            job.cancel()
        }

    @Test
    fun `GIVEN a GrandPrixViewModel WHEN fetchData is called THEN an error is thrown and ui need to be updated with an error`() =
        runTest {
            //Arrange
            viewModel = GrandPrixViewModel(useCase)
            coEvery { useCase(2024) } coAnswers {
                delay(50)
                throw Exception()
            }

            val emittedStates = mutableListOf<GrandPrixUiState>()
            val job = launch {
                viewModel.uiState.toList(emittedStates)
            }

            //Act
            viewModel.fetchData()
            testDispatcher.scheduler.advanceUntilIdle()

            //Assert
            Assert.assertEquals(
                listOf(
                    GrandPrixUiState(),
                    GrandPrixUiState(isLoading = true),
                    GrandPrixUiState(
                        shouldShowError = true,
                        isLoading = false,
                    )
                ),
                emittedStates
            )

            job.cancel()
        }

    @Test
    fun `GIVEN a GrandPrixViewModel WHEN onRetryClick is called THEN error status should be false and fetchData should be called again`() =
        runTest {
            //Arrange
            val initialState = GrandPrixUiState(shouldShowError = true)

            viewModel = GrandPrixViewModel(useCase, initialState)
            coEvery { useCase(2024) } coAnswers {
                delay(50)
                grandPrixList
            }

            val emittedStates = mutableListOf<GrandPrixUiState>()
            val job = launch {
                viewModel.uiState.toList(emittedStates)
            }

            //Act
            runCurrent()
            viewModel.onRetryClick()
            testDispatcher.scheduler.advanceUntilIdle()

            //Assert
            Assert.assertEquals(
                listOf(
                    initialState,
                    GrandPrixUiState(shouldShowError = false),
                    GrandPrixUiState(isLoading = true),
                    GrandPrixUiState(
                        grandPrixList = grandPrixList,
                        isLoading = false,
                    )
                ),
                emittedStates
            )

            job.cancel()
        }

    @Test
    fun `GIVEN a GrandPrixViewModel WHEN onRetryClick is called THEN an error is thrown and ui need to be updated with an error`() =
        runTest {
            //Arrange
            val initialState = GrandPrixUiState(shouldShowError = true)

            viewModel = GrandPrixViewModel(useCase, initialState)
            coEvery { useCase(2024) } coAnswers {
                delay(50)
                throw Exception()
            }

            val emittedStates = mutableListOf<GrandPrixUiState>()
            val job = launch {
                viewModel.uiState.toList(emittedStates)
            }

            //Act
            runCurrent()
            viewModel.onRetryClick()
            testDispatcher.scheduler.advanceUntilIdle()

            //Assert
            Assert.assertEquals(
                listOf(
                    initialState,
                    GrandPrixUiState(shouldShowError = false),
                    GrandPrixUiState(isLoading = true),
                    GrandPrixUiState(
                        shouldShowError = true,
                        isLoading = false,
                    )
                ),
                emittedStates
            )

            job.cancel()
        }
}