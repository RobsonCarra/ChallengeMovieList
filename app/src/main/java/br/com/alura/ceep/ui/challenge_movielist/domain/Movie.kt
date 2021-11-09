package br.com.alura.ceep.ui.challenge_movielist.domain

import java.time.Year

class Movie(
    var id: Long,
    var title: String,
    var year: Long,
    var runtime: Long,
    var director: String,
    var actors: String,
    var plot: String,
    var image: String
)