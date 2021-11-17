package br.com.alura.ceep.ui.challenge_movielist.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.ceep.ui.challenge_movielist.R
import br.com.alura.ceep.ui.challenge_movielist.helpers.RetrofitConfig
import br.com.alura.ceep.ui.challenge_movielist.repository.MovieRepository
import br.com.alura.ceep.ui.challenge_movielist.viewmodel.MovieViewModel
import br.com.alura.ceep.ui.challenge_movielist.viewmodel.config.MovieViewModelFactory
import br.com.alura.ceep.ui.coffemachine.exceptions.BadGatewayException
import br.com.alura.ceep.ui.coffemachine.exceptions.BadRequestException
import br.com.alura.ceep.ui.coffemachine.exceptions.NoContentException
import br.com.alura.ceep.ui.coffemachine.exceptions.NotFoundException
import br.com.alura.ceep.ui.desafioandroid.presentation.custom.MovieAdapter
import kotlinx.coroutines.InternalCoroutinesApi

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private var movieAdapter: MovieAdapter = MovieAdapter(selected = { data ->
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("movie", data)
        startActivity(intent)
    })

    private val viewModel: MovieViewModel by viewModels {
        MovieViewModelFactory(
            MovieRepository(
                RetrofitConfig().getClient()
            )
        )
    }

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
        viewModel.getAll()
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        observers()
    }

    fun observers() {
        viewModel.list.observe(this) { movies ->
            recyclerView.adapter = movieAdapter
            recyclerView.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            movieAdapter.list.clear()
            movieAdapter.list.addAll(movies)
            movieAdapter.notifyDataSetChanged()
        }
        viewModel.error.observe(this) { exception ->
            when (exception) {
                is NoContentException -> {
                    recyclerView.visibility = View.GONE
                    progressBar.visibility = View.VISIBLE
                }
                is BadRequestException -> Toast.makeText(
                    this,
                    exception.message,
                    Toast.LENGTH_SHORT
                ).show()
                is NotFoundException -> Toast.makeText(
                    this,
                    exception.message,
                    Toast.LENGTH_SHORT
                ).show()
                is BadGatewayException -> Toast.makeText(
                    this,
                    exception.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun setup() {
        recyclerView = findViewById(R.id.recycler)
        progressBar = findViewById(R.id.progress_bar)
    }
}