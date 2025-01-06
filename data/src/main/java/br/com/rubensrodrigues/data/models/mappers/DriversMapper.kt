package br.com.rubensrodrigues.data.models.mappers

import br.com.rubensrodrigues.data.models.ConstructorModel
import br.com.rubensrodrigues.data.models.DriversModel
import br.com.rubensrodrigues.domain.entities.Driver

fun DriversModel.toDriversList() = this
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

private fun List<ConstructorModel>.decorateConstructors() = this.joinToString(" / ") { it.name }