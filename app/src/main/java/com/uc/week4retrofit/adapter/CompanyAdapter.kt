package com.uc.week4retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uc.week4retrofit.R
import com.uc.week4retrofit.helper.Const
import com.uc.week4retrofit.model.Genre
import com.uc.week4retrofit.model.ProductionCompany

class CompanyAdapter (private val dataSet: List<ProductionCompany>) :
    RecyclerView.Adapter<CompanyAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgCompany: ImageView

        init {
            imgCompany = view.findViewById(R.id.img_listcompany)
        }
    }
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CompanyAdapter.ViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_company, viewGroup, false)

        return CompanyAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: CompanyAdapter.ViewHolder, position: Int) {

        Glide.with(viewHolder.itemView)
            .load(Const.IMG_URL + dataSet[position].logo_path).into(viewHolder.imgCompany)

    }

    override fun getItemCount() = dataSet.size


}