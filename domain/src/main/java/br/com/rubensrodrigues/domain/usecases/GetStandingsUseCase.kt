package br.com.rubensrodrigues.domain.usecases

import br.com.rubensrodrigues.domain.entities.Constructor
import br.com.rubensrodrigues.domain.entities.Driver

fun interface GetStandingsUseCase : suspend (Int) -> Pair<List<Driver>, List<Constructor>>