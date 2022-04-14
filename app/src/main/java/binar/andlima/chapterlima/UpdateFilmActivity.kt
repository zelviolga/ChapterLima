package binar.andlima.chapterlima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import binar.andlima.chapterlima.model.GetAllFilmResponseItem
import binar.andlima.chapterlima.model.RequesFilm
import binar.andlima.chapterlima.network.ApiClient
import kotlinx.android.synthetic.main.activity_update_film.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateFilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_film)

        val getfilm = intent.getParcelableExtra<GetAllFilmResponseItem>("updatefilm")

        update_namefilm.setText(getfilm?.name)
        update_directorfilm.setText(getfilm?.director)
        update_imagefilm.setText(getfilm?.image)
        update_descfilm.setText(getfilm?.description)

        btn_updatefilm.setOnClickListener {
            val id = getfilm?.id
            val name = update_namefilm.text.toString()
            val image = update_imagefilm.text.toString()
            val director = update_directorfilm.text.toString()
            val description = update_descfilm.text.toString()
            updateDataFilm(id!!.toInt() , description, director, image,name)
            finish()
        }

    }

    fun updateDataFilm(id :Int, name: String,img :String, desc: String,direct : String){
        ApiClient.instance.updateFilm(id, RequesFilm(desc,direct,img,name))
            .enqueue(object : Callback<List<GetAllFilmResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllFilmResponseItem>>,
                    response: Response<List<GetAllFilmResponseItem>>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@UpdateFilmActivity, response.message(),Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@UpdateFilmActivity, response.message(),Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<List<GetAllFilmResponseItem>>, t: Throwable) {
                    Toast.makeText(this@UpdateFilmActivity, t.message,Toast.LENGTH_LONG).show()
                }
            })
    }


}