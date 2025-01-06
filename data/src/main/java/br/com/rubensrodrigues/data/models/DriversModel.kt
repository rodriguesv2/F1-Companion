package br.com.rubensrodrigues.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DriversModel(
    @SerialName("MRData") val data: DriversMRDataModel
)

@Serializable
data class DriversMRDataModel(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: Int,
    val offset: Int,
    val total: Int,
    @SerialName("StandingsTable") val standingsTable: DriversStandingsTableModel
)

@Serializable
data class DriversStandingsTableModel(
    @SerialName("DriverStandings") val driverStandings: List<DriverStandingModel>
)

@Serializable
data class DriverStandingModel(
    val position: String,
    val points: String,
    @SerialName("Driver") val driver: DriverModel,
    @SerialName("Constructors") val constructors: List<ConstructorModel>
)

@Serializable
data class DriverModel(
    val givenName: String,
    val familyName: String,
)

@Serializable
data class ConstructorModel(
    val name: String,
)
