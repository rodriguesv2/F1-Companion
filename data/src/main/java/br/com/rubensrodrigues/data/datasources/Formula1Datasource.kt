package br.com.rubensrodrigues.data.datasources

import br.com.rubensrodrigues.data.models.ConstructorsResponse
import br.com.rubensrodrigues.data.models.DriversResponse
import br.com.rubensrodrigues.data.models.RacingsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

interface Formula1Datasource {
    suspend fun getRaces(year: Int) : RacingsResponse
    suspend fun getDrivers(year: Int) : DriversResponse
    suspend fun getConstructors(year: Int) : ConstructorsResponse
}

class Formula1DatasourceImpl(
    private val client: HttpClient
): Formula1Datasource {
    override suspend fun getRaces(year: Int) : RacingsResponse {
        return client
            .get("$year/races.json")
            .body<RacingsResponse>()
    }

    override suspend fun getDrivers(year: Int): DriversResponse {
        return client
            .get("$year/driverstandings.json")
            .body<DriversResponse>()
    }

    override suspend fun getConstructors(year: Int): ConstructorsResponse {
        return client
            .get("$year/constructorstandings.json")
            .body<ConstructorsResponse>()
    }
}