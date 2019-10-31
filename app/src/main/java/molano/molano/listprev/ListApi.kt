package molano.molano.listprev

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://my-json-server.typicode.com/bgdom/cours-android/"
interface ListApi {

    @GET("games?")
    fun getGames() : Call<List<Games>>

    companion object {
        operator fun invoke() : ListApi{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ListApi::class.java)
        }
    }
}