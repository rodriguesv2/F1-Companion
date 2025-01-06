package br.com.rubensrodrigues.data.models.mappers

import br.com.rubensrodrigues.data.models.ConstructorResponse
import br.com.rubensrodrigues.data.models.DriversResponse
import br.com.rubensrodrigues.domain.entities.Driver

fun DriversResponse.toDriversList() = this
    .data
    .standingsTable
    .driverStandings
    .map {
        Driver(
            driver = "${it.driver.givenName} ${it.driver.familyName}",
            points = it.points,
            position = it.position,
            team = it.constructors.decorateConstructors()
        )
    }

private fun List<ConstructorResponse>.decorateConstructors() = this.joinToString(" / ") { it.name }