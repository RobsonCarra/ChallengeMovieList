package br.com.alura.ceep.ui.desafioandroid.presentation.custom

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.ceep.ui.challenge_movielist.R
import br.com.alura.ceep.ui.challenge_movielist.domain.Movie
import com.squareup.picasso.Picasso
import java.time.*
import java.util.*

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val name: TextView
    var year: TextView
    var image: ImageView
    var duration: TextView

    init {
        name = itemView.findViewById(R.id.name_movies_item)
        year = itemView.findViewById(R.id.year_item)
        image = itemView.findViewById(R.id.image_movie_item)
        duration = itemView.findViewById(R.id.duration_item)
    }

    fun bind(movie: Movie) {
        name.text = movie.title
        year.text = movie.year.toString()
        Picasso.get().load(movie.posterUrl)
            .into(image)
        duration.text = movie.runtime.toString() + " min"
    }
}