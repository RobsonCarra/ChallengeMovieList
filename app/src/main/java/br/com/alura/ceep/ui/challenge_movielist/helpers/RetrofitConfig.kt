package br.com.alura.ceep.ui.challenge_movielist.helpers

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    fun getClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://mocki.io/v1/ad07ea3d-ce43-49e7-ad58-29dcdef136f5")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().build()
            ).build()
    }
}