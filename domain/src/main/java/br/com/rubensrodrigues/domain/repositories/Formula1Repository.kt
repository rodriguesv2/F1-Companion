package br.com.rubensrodrigues.domain.repositories

import br.com.rubensrodrigues.domain.entities.Constructor
import br.com.rubensrodrigues.domain.entities.Driver
import br.com.rubensrodrigues.domain.entities.GrandPrix

interface Formula1Repository {
    suspend fun getGrandPrix(currentYear: Int): List<GrandPrix>
    suspend fun getStandings(currentYear: Int): Pair<List<Driver>, List<Constructor>>
}