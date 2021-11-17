package br.com.alura.ceep.ui.desafioandroid.presentation.custom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.ceep.ui.challenge_movielist.R
import br.com.alura.ceep.ui.challenge_movielist.domain.Movie

class MovieAdapter(val selected: (movie: Movie) -> Unit) :
    RecyclerView.Adapter<MovieViewHolder>(
    ) {
    var list = ArrayList<Movie>()
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.item_movie_list, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(list.get(position))
        holder.itemView.setOnClickListener { v: View? ->
            selected(list.get(position))
        }
    }

    override fun getItemCount(): Int {
        return list.count()
    }
}