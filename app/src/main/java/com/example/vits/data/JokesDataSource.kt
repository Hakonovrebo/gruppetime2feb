package com.example.vits.data;

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.gson.gson

class JokesDataSource(private val path: String = "https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/ukesoppgaver/jokes.json") {

    private val client = HttpClient() {
        install(ContentNegotiation) {
            gson()
        }
    }

    suspend fun fetchJokes(): List<Joke> {
        val jokes: Jokes = client.get(path).body()
        return jokes.jokes
    }

}
