package com.uc.week4retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uc.week4retrofit.R
import com.uc.week4retrofit.model.Genre
import com.uc.week4retrofit.model.ProductionCountry

class CountryAdapter (private val dataSet: List<ProductionCountry>) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCountry: TextView

        init {
            tvCountry = view.findViewById(R.id.tv_listcountry)
        }
    }
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CountryAdapter.ViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_genre, viewGroup, false)

        return CountryAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: CountryAdapter.ViewHolder, position: Int) {

        viewHolder.tvCountry.text = dataSet[position].name

    }

    override fun getItemCount() = dataSet.size

}