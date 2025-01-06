package br.com.rubensrodrigues.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConstructorsResponse(
    @SerialName("MRData") val data: ConstructorsMRDataResponse
)

@Serializable
data class ConstructorsMRDataResponse(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: Int,
    val offset: Int,
    val total: Int,
    @SerialName("StandingsTable") val standingsTable: ConstructorsStandingsTableResponse
)

@Serializable
data class ConstructorsStandingsTableResponse(
    @SerialName("ConstructorStandings") val constructorStandings: List<ConstructorStandingResponse>
)

@Serializable
data class ConstructorStandingResponse(
    val position: String,
    val points: String,
    @SerialName("Constructor") val constructor: ConstructorResponse,
)


