package molano.molano.listprev

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class GameDetailActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewGames.layoutManager = LinearLayoutManager(this)
        recyclerViewGames.adapter = GameDetailAdapter()
    }
    private class GameDetailAdapter: RecyclerView.Adapter<GameDetailViewHolder>(){
        override fun getItemCount(): Int {
            return 5
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameDetailViewHolder {
            val layoutInflater = LayoutInflater.from(parent?.context)
            val blueView = View(parent?.context)
            blueView.setBackgroundColor(Color.BLUE)
            blueView.minimumHeight = 50
            return GameDetailViewHolder(blueView)
        }

        override fun onBindViewHolder(holder: GameDetailViewHolder, position: Int) {

        }
    }
    private class GameDetailViewHolder(val customView: View): RecyclerView.ViewHolder(customView){

    }
}