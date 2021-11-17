package br.com.alura.ceep.ui.challenge_movielist.viewmodel.config

import br.com.alura.ceep.ui.challenge_movielist.repository.MovieRepository
import br.com.alura.ceep.ui.challenge_movielist.viewmodel.MovieViewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MovieViewModelFactory(
    private val movieRepository: MovieRepository,
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieViewModel(movieRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}