package br.com.alura.ceep.ui.challenge_movielist.domain

import java.time.Year

class Movie(
    id: Long,
    title: String,
    year: Long,
    runtime: Long,
    director: String,
    actors: String,
    plot: String,
    image: String
)