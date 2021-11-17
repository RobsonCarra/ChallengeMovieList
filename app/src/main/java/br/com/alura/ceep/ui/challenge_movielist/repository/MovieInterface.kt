package br.com.alura.ceep.ui.challenge_movielist.repository

import br.com.alura.ceep.ui.challenge_movielist.domain.ApiResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import java.lang.reflect.Array
import java.util.*

interface MovieInterface {
    @GET(GET_ALL)
    fun getAll(): Deferred<Response<ApiResponse>>

    companion object {
        const val GET_ALL = "v1/ad07ea3d-ce43-49e7-ad58-29dcdef136f5"
    }
}