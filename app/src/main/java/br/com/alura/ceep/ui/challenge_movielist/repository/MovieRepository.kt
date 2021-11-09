package br.com.alura.ceep.ui.challenge_movielist.repository

import br.com.alura.ceep.ui.challenge_movielist.domain.Movie
import br.com.alura.ceep.ui.coffemachine.exceptions.BadGatewayException
import br.com.alura.ceep.ui.coffemachine.exceptions.BadRequestException
import br.com.alura.ceep.ui.coffemachine.exceptions.NoContentException
import br.com.alura.ceep.ui.coffemachine.exceptions.NotFoundException
import br.com.alura.ceep.ui.desafioandroid.helpers.Res
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import java.lang.Exception
import java.net.HttpURLConnection

class MovieRepository(private val client: Retrofit) {
    suspend fun getAll() = flow {
        val api = client.create(MovieInterface::class.java)
        val req = api.getAll()
        val res = req.await()
        when (res.code()) {
            HttpURLConnection.HTTP_OK -> emit(Res.Success(res.body() as List<Movie>))
            HttpURLConnection.HTTP_NOT_FOUND -> emit(Res.Failure(NotFoundException()))
            HttpURLConnection.HTTP_BAD_REQUEST -> emit(Res.Failure(BadRequestException()))
            HttpURLConnection.HTTP_BAD_GATEWAY -> emit(Res.Failure(BadGatewayException()))
            HttpURLConnection.HTTP_NO_CONTENT -> emit(Res.Failure(NoContentException()))
            else -> emit(Res.Failure(Exception("Erro Generico")))
        }
    }
}