package br.com.rubensrodrigues.data.repositories.local

import br.com.rubensrodrigues.domain.entities.GrandPrix
import br.com.rubensrodrigues.domain.repositories.Formula1Repository
import kotlinx.coroutines.delay

class Formula1RepositoryMock: Formula1Repository {
    override suspend fun getGrandPrix(currentYear: Int): List<GrandPrix> {
        delay(1500)

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
}