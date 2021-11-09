package br.com.alura.ceep.ui.desafioandroid.presentation.custom

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.ceep.ui.challenge_movielist.R
import br.com.alura.ceep.ui.challenge_movielist.domain.Movie
import java.text.SimpleDateFormat
import java.time.*
import java.util.*

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var name: TextView
    var year: TextView
    var image: ImageView
    var duration: TextView

    init {
        name = itemView.findViewById(R.id.name_movies)
        year = itemView.findViewById(R.id.year)
        image = itemView.findViewById(R.id.image_movie)
        duration = itemView.findViewById(R.id.duration)
    }

    fun bind(movie: Movie) {
        name.text = movie.title
        year.text = movie.year.toString()
        Picasso.get().load(movie.image)
            .placeholder(R.drawable.ic_launcher_background)
            .into(image)
        duration.text = movie.runtime.toString()
    }
}