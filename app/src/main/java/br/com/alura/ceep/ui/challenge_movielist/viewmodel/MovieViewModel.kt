package br.com.alura.ceep.ui.challenge_movielist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.ceep.ui.challenge_movielist.domain.Movie
import br.com.alura.ceep.ui.challenge_movielist.repository.MovieRepository
import br.com.alura.ceep.ui.desafioandroid.helpers.Res
import kotlinx.coroutines.launch

open class MovieViewModel(private val movieRepository: MovieRepository): ViewModel() {
    val list = MutableLiveData<List<Movie>>()
    val error = MutableLiveData<Exception>()

    fun getAll() {
        viewModelScope.launch {
            movieRepository.getAll().collect { result ->
                when (result) {
                    is Res.Success -> list.postValue(result.items as List<Movie>)
                    is Res.Failure -> error.postValue(result.exception)
                }
            }
        }
    }
}