package br.com.rubensrodrigues.domain.entities

data class GrandPrix(
    val days: Pair<String, String>,
    val month: String,
    val round: String,
    val location: String,
    val name: String
)