package br.com.rubensrodrigues.data.repositories.local

import br.com.rubensrodrigues.domain.entities.Constructor
import br.com.rubensrodrigues.domain.entities.Driver
import br.com.rubensrodrigues.domain.entities.GrandPrix
import br.com.rubensrodrigues.domain.repositories.Formula1Repository
import kotlinx.coroutines.delay

class Formula1RepositoryMock : Formula1Repository {
    override suspend fun getGrandPrix(currentYear: Int): List<GrandPrix> {
        delay(DELAY)

        return List(20) {
            GrandPrix(
                day = "01",
                month = "November",
                round = "1",
                location = "São Paulo",
                name = "São Paulo Grand Prix"
            )
        }
    }

    override suspend fun getStandings(currentYear: Int): Pair<List<Driver>, List<Constructor>> {
        delay(DELAY)

        return List(20) {
            Driver(
                position = "1",
                driver = "Carlos Sainz",
                points = "100",
                team = "Ferrari",
            )
        } to List(10) {
            Constructor(
                position = "1",
                points = "100",
                team = "Ferrari",
            )
        }
    }
}

const val DELAY = 1500L