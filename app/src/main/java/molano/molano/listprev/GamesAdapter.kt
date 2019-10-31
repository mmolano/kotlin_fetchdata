package molano.molano.listprev

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView



import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_games.view.*

class GamesAdapter(val games : List<Games>) : RecyclerView.Adapter<GamesAdapter.GamesViewHolder>() {

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
    return GamesViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_games, parent, false)
    )
}

override fun getItemCount() = games.size

override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
    val game = games[position]
    holder.view.textViewTitle.text = game.name

    Picasso.get().load(game.img).into(holder.view.imageView)

}


class GamesViewHolder(val view: View) : RecyclerView.ViewHolder(view){
    init{
        view.setOnClickListener {
            val intent = Intent(view.context, GameDetailActivity::class.java)
            view.context.startActivity(intent)
        }
    }
}
}