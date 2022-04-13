package binar.andlima.chapterlima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import binar.andlima.chapterlima.model.PostFilmResponse
import binar.andlima.chapterlima.model.RequesFilm
import binar.andlima.chapterlima.network.ApiClient
import kotlinx.android.synthetic.main.activity_add_film.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddFilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_film)

        btn_addfilm.setOnClickListener {
            val name =  add_namefilm.text.toString()
            val img = add_imagefilm.text.toString()
            val director = add_directorfilm.text.toString()
            val desc = add_descfilm.text.toString()
            postDataFilm(desc,director,img,name)
            finish()
        }
    }

    fun postDataFilm(desc: String, direct: String, img: String, name: String) {
        ApiClient.instance.postFilm(RequesFilm(desc, direct, img, name))
            .enqueue(object : Callback<PostFilmResponse>{
                override fun onResponse(
                    call: Call<PostFilmResponse>,
                    response: Response<PostFilmResponse>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@AddFilmActivity, response.message(), Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@AddFilmActivity, response.message(), Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<PostFilmResponse>, t: Throwable) {
                   Toast.makeText(this@AddFilmActivity, t.message, Toast.LENGTH_LONG).show()
                }

            })
    }

}