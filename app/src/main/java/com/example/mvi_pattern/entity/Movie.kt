package com.example.mvi_pattern.entity

data class Movie(
    val id: Long = 0L,
    val title: String,
    val posterPath: String = "",
    val backdropPath: String = "",
    val releaseDate: String = "",
    val overview: String = ""
)
