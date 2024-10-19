package com.example.mvi_pattern

import androidx.compose.runtime.remember
import com.example.mvi_pattern.entity.Movie

class MainViewModel {
    var viewState = ViewState() //make it mutable let's use remember {}

    fun getMovies() {
        viewState = ViewState(isLoading = true, movies = emptyList(), error = "")
        // get movies from repository by using kotlin coroutines
        // update viewState

    }
}


data class ViewState (
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = ""
)
