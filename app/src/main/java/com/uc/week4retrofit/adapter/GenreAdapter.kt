package com.uc.week4retrofit.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uc.week4retrofit.R
import com.uc.week4retrofit.model.Genre


class GenreAdapter (private val dataSet: List<Genre>) :
    RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvGenre: TextView

        init {
            tvGenre = view.findViewById(R.id.tv_listcountry)
        }
    }
        override fun onCreateViewHolder(
            viewGroup: ViewGroup,
            viewType: Int
        ): GenreAdapter.ViewHolder {

            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_genre, viewGroup, false)

            return GenreAdapter.ViewHolder(view)
        }

        override fun onBindViewHolder(viewHolder: GenreAdapter.ViewHolder, position: Int) {

            viewHolder.tvGenre.text = dataSet[position].name

        }

        override fun getItemCount() = dataSet.size

}