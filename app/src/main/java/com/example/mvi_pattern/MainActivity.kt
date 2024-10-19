package com.example.mvi_pattern

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mvi_pattern.entity.Movie
import com.example.mvi_pattern.ui.theme.MovieView
import com.example.mvi_pattern.ui.theme.MvipatternTheme

class MainActivity : ComponentActivity() {

    val viewModel by lazy { MainViewModel() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           // when viewModel.viewState.movies is updated trigger Greeting
            MvipatternTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        movieItems = listOf(Movie(title = "Android"), Movie(title = "IOS")),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(movieItems: List<Movie>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Set 2 columns for the grid
        modifier = modifier.fillMaxSize()
    ) {
        items(movieItems) { movie ->
            MovieView(movie)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MvipatternTheme {
        Greeting(movieItems = listOf(Movie(title = "Android"), Movie(title = "IOS"),
            Movie(title = "Android"), Movie(title = "IOS"),
            Movie(title = "Android"), Movie(title = "IOS"),
            Movie(title = "Android"), Movie(title = "IOS")))
    }
}
