package br.com.rubensrodrigues.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RacingsModel(
    @SerialName("MRData") val data: MRDataModel
)

@Serializable
data class MRDataModel(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: Int,
    val offset: Int,
    val total: Int,
    @SerialName("RaceTable") val raceTable: RaceTableModel
)

@Serializable
data class RaceTableModel(
    val season: String,
    @SerialName("Races") val races: List<RaceModel>

)

@Serializable
data class RaceModel(
    val season: String,
    val round: String,
    val url: String,
    val raceName: String,
    @SerialName("Circuit") val circuit: CircuitModel,
    val date: String,
    val time: String,
    @SerialName("FirstPractice") val firstPractice: DateTimeModel?,
    @SerialName("SecondPractice") val secondPractice: DateTimeModel?,
    @SerialName("ThirdPractice") val thirdPractice: DateTimeModel?,
    @SerialName("Qualifying") val qualify: DateTimeModel?,
    @SerialName("Sprint") val sprint: DateTimeModel?,
    @SerialName("SprintQualifying") val sprintQualifying: DateTimeModel?,
)

@Serializable
data class CircuitModel(
    val circuitId: String,
    val url: String,
    val circuitName: String,
    @SerialName("Location") val location: LocationModel,
)

@Serializable
data class DateTimeModel(
    val date: String,
    val time: String
)

@Serializable
data class LocationModel(
    val lat: String,
    val long: String,
    val locality: String,
    val country: String
)
