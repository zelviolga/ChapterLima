package binar.andlima.chapterlima.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.andlima.chapterlima.R
import binar.andlima.chapterlima.model.GetAllFilmResponseItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_film.view.*

class AdapterFilm(private var datafilm : List<GetAllFilmResponseItem>, private var onclick : (GetAllFilmResponseItem)->Unit ): RecyclerView.Adapter<AdapterFilm.ViewHolder>() {


    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFilm.ViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_film, parent, false)
        return  ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: AdapterFilm.ViewHolder, position: Int) {
        holder.itemView.tv_judulfilm.text = datafilm[position].name
        holder.itemView.tv_tglfilm.text = datafilm[position].date
        holder.itemView.tv_sutradarafilm.text = datafilm[position].director
        Glide.with(holder.itemView.context).load(datafilm[position].image).into(holder.itemView.img_film)

        holder.itemView.cardFilm.setOnClickListener {
            onclick(datafilm[position])
        }
    }

    override fun getItemCount(): Int {
        return datafilm.size
    }

}