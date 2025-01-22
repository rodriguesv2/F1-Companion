package br.com.rubensrodrigues.presentation.ui.pages.standings

import br.com.rubensrodrigues.domain.entities.Constructor
import br.com.rubensrodrigues.domain.entities.Driver
import br.com.rubensrodrigues.domain.usecases.GetStandingsUseCase
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
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class StandingsViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: StandingsViewModel
    private val useCase: GetStandingsUseCase = mockk()

    private val mockDrivers = List(20) {
        Driver(
            position = it.toString(),
            driver = "Driver $it",
            team = "Team $it",
            points = it.toString(),
        )
    }
    private val mockConstructors = List(10) {
        Constructor(
            position = it.toString(),
            team = "Constructor $it",
            points = it.toString(),
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
    fun `GIVEN a StandingsViewModel WHEN fetchData is called THEN uiState is updated with drivers and constructors`() =
        runTest {
            // Arrange
            viewModel = StandingsViewModel(useCase)
            coEvery { useCase(2024) } coAnswers {
                delay(50)
                mockDrivers to mockConstructors
            }

            val emittedStates = mutableListOf<StandingsUiState>()
            val job = launch {
                viewModel.uiState.toList(emittedStates)
            }

            // Act
            viewModel.fetchData()
            testDispatcher.scheduler.advanceUntilIdle()

            // Assert
            assertEquals(
                listOf(
                    StandingsUiState(),
                    StandingsUiState(isLoading = true),
                    StandingsUiState(
                        drivers = mockDrivers,
                        constructors = mockConstructors,
                        isLoading = false
                    )
                ),
                emittedStates
            )

            job.cancel()
        }

    @Test
    fun `GIVEN a StandingsViewModel WHEN fetchData throws exception THEN uiState is updated with error`() =
        runTest {
            // Arrange
            viewModel = StandingsViewModel(useCase)
            coEvery { useCase(2024) } coAnswers {
                delay(50)
                throw RuntimeException("Network error")
            }

            val emittedStates = mutableListOf<StandingsUiState>()
            val job = launch {
                viewModel.uiState.toList(emittedStates)
            }

            // Act
            viewModel.fetchData()
            testDispatcher.scheduler.advanceUntilIdle()

            // Assert
            assertEquals(
                listOf(
                    StandingsUiState(),
                    StandingsUiState(isLoading = true),
                    StandingsUiState(shouldShowError = true)
                ),
                emittedStates
            )

            job.cancel()
        }

    @Test
    fun `GIVEN a StandingsViewModel WHEN onRetryClick is called THEN shouldShowError is cleared and fetchData is called`() =
        runTest {
            // Arrange
            val initialState = StandingsUiState(shouldShowError = true)
            viewModel = StandingsViewModel(useCase, initialState)

            coEvery { useCase(2024) } coAnswers {
                delay(50)
                mockDrivers to mockConstructors
            }

            val emittedStates = mutableListOf<StandingsUiState>()
            val job = launch {
                viewModel.uiState.toList(emittedStates)
            }

            // Act
            runCurrent()
            viewModel.onRetryClick()
            testDispatcher.scheduler.advanceUntilIdle()

            // Assert
            assertEquals(
                listOf(
                    initialState,
                    StandingsUiState(shouldShowError = false),
                    StandingsUiState(isLoading = true),
                    StandingsUiState(
                        drivers = mockDrivers,
                        constructors = mockConstructors,
                        isLoading = false
                    )
                ),
                emittedStates
            )

            job.cancel()
        }
}