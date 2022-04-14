package binar.andlima.chapterlima.network

import binar.andlima.chapterlima.model.GetAllFilmResponseItem
import binar.andlima.chapterlima.model.PostFilmResponse
import binar.andlima.chapterlima.model.RequesFilm
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("film")
    fun getAllFilm() : Call<List<GetAllFilmResponseItem>>

    @POST("film")
    fun postFilm(@Body req : RequesFilm) : Call<PostFilmResponse>

    @DELETE("film/{id}")
    fun deleteFilm(@Path ("id") id :Int):Call<Int>

    @PUT("film/{id}")
    fun updateFilm(
        @Path("id") id : Int,
        @Body reques : RequesFilm
    )
    : Call<List<GetAllFilmResponseItem>>



}