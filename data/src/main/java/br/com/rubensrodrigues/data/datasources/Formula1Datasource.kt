package br.com.rubensrodrigues.data.datasources

import br.com.rubensrodrigues.data.models.RacingsModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

interface Formula1Datasource {
    suspend fun getRaces(year: Int) : RacingsModel
}

class Formula1DatasourceImpl(
    private val client: HttpClient
): Formula1Datasource {
    override suspend fun getRaces(year: Int) : RacingsModel {
        return client
            .get("http://ergast.com/api/f1/$year/races.json")
            .body<RacingsModel>()
    }
}