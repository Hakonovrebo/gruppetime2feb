package com.example.vits.ui.joke

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vits.data.Joke

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JokeScreen(jokesViewModel: JokesViewModel = viewModel()) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Vitser! :)") })}
    ) { innerPadding ->

        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(jokesViewModel.jokeUiState.jokes) { joke ->
                JokeCard(joke = joke)
            }
        }
    }
}

@Composable
fun JokeCard(joke : Joke) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(joke.joke, modifier = Modifier.padding(16.dp))
    }
}











