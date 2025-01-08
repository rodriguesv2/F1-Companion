package br.com.rubensrodrigues.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DriversResponse(
    @SerialName("MRData") val data: DriversMRDataResponse
)

@Serializable
data class DriversMRDataResponse(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: Int,
    val offset: Int,
    val total: Int,
    @SerialName("StandingsTable") val standingsTable: DriversStandingsTableResponse
)

@Serializable
data class DriversStandingsTableResponse(
    @SerialName("StandingsLists") val standingsLists: List<DriversStandingsListResponse>
)

@Serializable
data class DriversStandingsListResponse(
    @SerialName("DriverStandings") val driverStandings: List<DriverStandingResponse>
)

@Serializable
data class DriverStandingResponse(
    val position: String,
    val points: String,
    @SerialName("Driver") val driver: DriverResponse,
    @SerialName("Constructors") val constructors: List<ConstructorResponse>
)

@Serializable
data class DriverResponse(
    val givenName: String,
    val familyName: String,
)

@Serializable
data class ConstructorResponse(
    val name: String,
)
