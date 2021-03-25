package com.example.pcconfigurator.Presentation.Adapters.ViewHolders

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pcconfigurator.Data.Models.Configuration
import com.example.pcconfigurator.R

class ConfigurationsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title = itemView.findViewById<TextView>(R.id.configuration_title)
    private val accessoriesQuantity = itemView.findViewById<TextView>(R.id.accessories_quantity)
    private val totalprice = itemView.findViewById<TextView>(R.id.total_price)


    @SuppressLint("SetTextI18n")
    fun initData(configuration: Configuration) {
        title.text = configuration.id.toString()
        accessoriesQuantity.text =
            configuration.accessoryQuantity.toString() + "/" + configuration.requiredQuantity.toString()
        totalprice.text = configuration.totalPrice.toString()
    }
}