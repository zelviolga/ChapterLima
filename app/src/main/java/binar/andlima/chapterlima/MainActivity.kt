package binar.andlima.chapterlima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import binar.andlima.chapterlima.adapter.AdapterFilm
import binar.andlima.chapterlima.model.GetAllFilmResponseItem
import binar.andlima.chapterlima.network.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDataFilm()

    }

    fun  getDataFilm(){
        ApiClient.instance.getAllFilm()
            .enqueue(object : retrofit2.Callback<List<GetAllFilmResponseItem>>{

                override fun onResponse(
                    call: Call<List<GetAllFilmResponseItem>>,
                    response: Response<List<GetAllFilmResponseItem>>
                ) {
                    if (response.isSuccessful){
                        val dataFilm = response.body()
                        val adapterfilm =   AdapterFilm(dataFilm!!){
                            val pindah = Intent(this@MainActivity, DetailFilm::class.java)
                            pindah.putExtra("detailfilm",it )
                            startActivity(pindah)
                        }
                        val lm = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false )
                        rvFilm.layoutManager = lm
                        rvFilm.adapter = adapterfilm
                    }else{
                        Toast.makeText(this@MainActivity, response.message() , Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllFilmResponseItem>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message , Toast.LENGTH_LONG).show()
                }


            })
    }

    override fun onResume() {
        super.onResume()
        getDataFilm()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}