package binar.andlima.chapterlima

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import binar.andlima.chapterlima.model.GetAllFilmResponseItem
import binar.andlima.chapterlima.network.ApiClient
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_film.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFilm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)

        val detailfilm = intent.getParcelableExtra<GetAllFilmResponseItem>("detailfilm")

        tv_detailjudulfilm.text = detailfilm?.name
        tv_detailtglfilm.text = detailfilm?.date
        tv_detailsutradarafilm.text = detailfilm?.director
        detail_filmdesc.text = detailfilm?.description

        Glide.with(this).load(detailfilm?.image).into(detail_imgfilm)

        deleteFilm.setOnClickListener{

            AlertDialog.Builder(this)
                .setTitle("Hapus Data")
                .setMessage("Yakin hapus data ?")
                .setPositiveButton("ya"){ dialogInterface: DialogInterface, i: Int ->
                    deleteDataFilm(detailfilm?.id!!.toInt())
                    finish()
                }
                .setNegativeButton("Tidak"){ dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.dismiss()
                }
                .show()

        }

//        klik btn update pindah ke activity update film dan bawa data
        updateFilm.setOnClickListener {
            val pindah = Intent(this, UpdateFilmActivity::class.java)
            pindah.putExtra("updatefilm",detailfilm )
            startActivity(pindah)
        }

    }

    fun deleteDataFilm(id : Int){
        ApiClient.instance.deleteFilm(id)
            .enqueue(object : Callback<Int>{
                override fun onResponse(call: Call<Int>, response: Response<Int>) {
                    if (response.isSuccessful){
                        Toast.makeText(this@DetailFilm, "Success", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@DetailFilm, "Failed", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Int>, t: Throwable) {
                    Toast.makeText(this@DetailFilm, t.message, Toast.LENGTH_LONG).show()
                }
            })
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }





}