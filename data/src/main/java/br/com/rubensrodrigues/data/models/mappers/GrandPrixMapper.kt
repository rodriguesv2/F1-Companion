package br.com.rubensrodrigues.data.models.mappers

import br.com.rubensrodrigues.data.models.RacingsResponse
import br.com.rubensrodrigues.domain.entities.GrandPrix
import br.com.rubensrodrigues.utils.getDay
import br.com.rubensrodrigues.utils.getMonth

fun RacingsResponse.toGrandPrixList() = this
    .data
    .raceTable
    .races
    .map { race ->
        GrandPrix(
            day = race.date.getDay(),
            month = race.date.getMonth(),
            round = race.round,
            location = race.circuit.location.country,
            name = race.raceName
        )
    }
