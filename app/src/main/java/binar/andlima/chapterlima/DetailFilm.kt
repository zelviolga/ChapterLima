package binar.andlima.chapterlima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.andlima.chapterlima.model.GetAllFilmResponseItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_film.*

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


    }
}