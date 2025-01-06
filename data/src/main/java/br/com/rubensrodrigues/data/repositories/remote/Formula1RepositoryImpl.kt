package br.com.rubensrodrigues.data.repositories.remote

import br.com.rubensrodrigues.data.datasources.Formula1Datasource
import br.com.rubensrodrigues.data.models.mappers.toConstructor
import br.com.rubensrodrigues.data.models.mappers.toDriversList
import br.com.rubensrodrigues.data.models.mappers.toGrandPrixList
import br.com.rubensrodrigues.domain.entities.Constructor
import br.com.rubensrodrigues.domain.entities.Driver
import br.com.rubensrodrigues.domain.repositories.Formula1Repository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class Formula1RepositoryImpl(private val datasource: Formula1Datasource) : Formula1Repository {
    override suspend fun getGrandPrix(currentYear: Int) = datasource
        .getRaces(currentYear)
        .toGrandPrixList()

    override suspend fun getStandings(currentYear: Int): Pair<List<Driver>, List<Constructor>>  = coroutineScope {
        val drivers = async { datasource.getDrivers(currentYear).toDriversList() }
        val constructors = async { datasource.getConstructors(currentYear).toConstructor() }
        Pair(drivers.await(), constructors.await())
    }
}