package com.example.vits.ui.joke

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vits.data.Joke
import com.example.vits.data.JokesDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

data class JokeUiState(
    val jokes: List<Joke>
)

class JokesViewModel : ViewModel() {

    private val jokesDataSource: JokesDataSource = JokesDataSource()

    var jokeUiState by mutableStateOf(JokeUiState(jokes = listOf()))
        private set

    init {
        loadJokes()
    }

    private fun loadJokes() {
        viewModelScope.launch(Dispatchers.IO) {
            val jokes = jokesDataSource.fetchJokes()
            jokeUiState = jokeUiState.copy(jokes = jokes)
        }
    }
}