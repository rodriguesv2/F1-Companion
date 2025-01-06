package br.com.rubensrodrigues.data.datasources

import br.com.rubensrodrigues.data.models.ConstructorsModel
import br.com.rubensrodrigues.data.models.DriversModel
import br.com.rubensrodrigues.data.models.RacingsModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

interface Formula1Datasource {
    suspend fun getRaces(year: Int) : RacingsModel
    suspend fun getDrivers(year: Int) : DriversModel
    suspend fun getConstructors(year: Int) : ConstructorsModel
}

class Formula1DatasourceImpl(
    private val client: HttpClient
): Formula1Datasource {
    override suspend fun getRaces(year: Int) : RacingsModel {
        return client
            .get("$year/races.json")
            .body<RacingsModel>()
    }

    override suspend fun getDrivers(year: Int): DriversModel {
        return client
            .get("$year/driverstandings.json")
            .body<DriversModel>()
    }

    override suspend fun getConstructors(year: Int): ConstructorsModel {
        return client
            .get("$year/constructorstandings.json")
            .body<ConstructorsModel>()
    }
}