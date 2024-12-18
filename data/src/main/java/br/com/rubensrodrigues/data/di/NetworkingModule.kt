package br.com.rubensrodrigues.data.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkingModule = module {
    single {
        HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
            defaultRequest {
                header(API_KEY, get(named(API_KEY_VALUE)))
                url("https://v1.formula-1.api-sports.io/")
            }
        }
    }
}

const val API_KEY = "x-apisports-key"
const val API_KEY_VALUE = "api_key_value"