package br.com.alura.ceep.ui.challenge_movielist.presentation

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import br.com.alura.ceep.ui.challenge_movielist.R
import br.com.alura.ceep.ui.challenge_movielist.domain.Movie
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var name: TextView
    private lateinit var description: TextView
    private lateinit var directorName: TextView
    private lateinit var actor: TextView
    private lateinit var year: TextView
    private lateinit var duration: TextView
    private lateinit var image: ImageView
    private lateinit var movieToolbar: Toolbar


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        setup()
        init()
        listeners()
    }

    private fun setup() {
        name = findViewById(R.id.name_movies_item_detail)
        description = findViewById(R.id.descrição)
        duration = findViewById(R.id.duration_item)
        directorName = findViewById(R.id.name_director)
        actor = findViewById(R.id.actors)
        year = findViewById(R.id.year_item)
        image = findViewById(R.id.image_movie_item_detail)
        movieToolbar = findViewById(R.id.movie_toolbar)
    }

    private fun listeners() {
        movieToolbar.setNavigationOnClickListener { arrow: View? ->
            onBackPressed()
        }
    }

    private fun init() {
        val movie: Movie = intent.getParcelableExtra("movie")!!
        movie?.let {
            name.text = it.title
            description.text = it.plot
            duration.text = it.runtime.toString() + " min"
            directorName.text = it.director
            actor.text = it.actors
            year.text = it.year.toString()
            Picasso.get().load(it.posterUrl)
                .into(image)
        }
    }
}

