package molano.molano.listprev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        refreshLayout.setOnRefreshListener {
            fetchGames()
        }

        fetchGames()

    }

    private fun fetchGames(){
        refreshLayout.isRefreshing = true

        ListApi().getGames().enqueue(object : Callback<List<Games>> {
            override fun onFailure(call: Call<List<Games>>, t: Throwable) {
                refreshLayout.isRefreshing = false
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Games>>, response: Response<List<Games>>) {
                refreshLayout.isRefreshing = false
                val games = response.body()

                games?.let {
                    showGames(it)
                }

            }

        })
    }

    private fun showGames(list: List<Games>) {
        recyclerViewGames.layoutManager = LinearLayoutManager(this)
        recyclerViewGames.adapter = GamesAdapter(list)
    }
}
