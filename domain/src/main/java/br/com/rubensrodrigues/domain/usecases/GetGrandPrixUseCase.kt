package br.com.rubensrodrigues.domain.usecases

import br.com.rubensrodrigues.domain.entities.GrandPrix

fun interface GetGrandPrixUseCase : suspend (Int) -> List<GrandPrix>