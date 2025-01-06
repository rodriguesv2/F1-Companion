package br.com.rubensrodrigues.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConstructorsModel(
    @SerialName("MRData") val data: ConstructorsMRDataModel
)

@Serializable
data class ConstructorsMRDataModel(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: Int,
    val offset: Int,
    val total: Int,
    @SerialName("StandingsTable") val standingsTable: ConstructorsStandingsTableModel
)

@Serializable
data class ConstructorsStandingsTableModel(
    @SerialName("ConstructorStandings") val constructorStandings: List<ConstructorStandingModel>
)

@Serializable
data class ConstructorStandingModel(
    val position: String,
    val points: String,
    @SerialName("Constructor") val constructor: ConstructorModel,
)


