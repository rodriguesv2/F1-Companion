package br.com.rubensrodrigues.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RacingsResponse(
    @SerialName("MRData") val data: RacingsMRDataResponse
)

@Serializable
data class RacingsMRDataResponse(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: Int,
    val offset: Int,
    val total: Int,
    @SerialName("RaceTable") val raceTable: RaceTableResponse
)

@Serializable
data class RaceTableResponse(
    val season: String,
    @SerialName("Races") val races: List<RaceResponse>

)

@Serializable
data class RaceResponse(
    val season: String,
    val round: String,
    val url: String,
    val raceName: String,
    @SerialName("Circuit") val circuit: CircuitResponse,
    val date: String,
    val time: String,
    @SerialName("FirstPractice") val firstPractice: DateTimeResponse?,
    @SerialName("SecondPractice") val secondPractice: DateTimeResponse?,
    @SerialName("ThirdPractice") val thirdPractice: DateTimeResponse?,
    @SerialName("Qualifying") val qualify: DateTimeResponse?,
    @SerialName("Sprint") val sprint: DateTimeResponse?,
    @SerialName("SprintQualifying") val sprintQualifying: DateTimeResponse?,
)

@Serializable
data class CircuitResponse(
    val circuitId: String,
    val url: String,
    val circuitName: String,
    @SerialName("Location") val location: LocationResponse,
)

@Serializable
data class DateTimeResponse(
    val date: String,
    val time: String
)

@Serializable
data class LocationResponse(
    val lat: String,
    val long: String,
    val locality: String,
    val country: String
)
