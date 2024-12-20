package br.com.rubensrodrigues.domain.repositories

import br.com.rubensrodrigues.domain.entities.GrandPrix

interface Formula1Repository {
    suspend fun getGrandPrix(currentYear: Int): List<GrandPrix>
}