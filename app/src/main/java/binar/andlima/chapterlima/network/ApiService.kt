package binar.andlima.chapterlima.network

import binar.andlima.chapterlima.model.GetAllFilmResponseItem
import binar.andlima.chapterlima.model.PostFilmResponse
import binar.andlima.chapterlima.model.RequesFilm
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("film")
    fun getAllFilm() : Call<List<GetAllFilmResponseItem>>

    @POST("film")
    fun postFilm(@Body req : RequesFilm) : Call<PostFilmResponse>



}