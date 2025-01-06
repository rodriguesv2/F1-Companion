package br.com.rubensrodrigues.data.models.mappers

import br.com.rubensrodrigues.data.models.ConstructorsResponse
import br.com.rubensrodrigues.domain.entities.Constructor

fun ConstructorsResponse.toConstructor() = this
    .data
    .standingsTable
    .constructorStandings
    .map {
        Constructor(
            team = it.constructor.name,
            points = it.points,
            position = it.position
        )
    }