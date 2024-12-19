package br.com.rubensrodrigues.data.models.mappers

import br.com.rubensrodrigues.data.models.RacingsModel
import br.com.rubensrodrigues.domain.entities.GrandPrix

fun RacingsModel.toGrandPrixList() = this
    .data
    .raceTable
    .races
    .map { race ->
        GrandPrix(
            days = race.date.split("-")[2] to race.date.split("-")[2], //TODO arrumar isso
            month = race.date.split("-")[1], //TODO arrumar isso
            round = race.round,
            location = race.circuit.location.country,
            name = race.raceName
        )
    }