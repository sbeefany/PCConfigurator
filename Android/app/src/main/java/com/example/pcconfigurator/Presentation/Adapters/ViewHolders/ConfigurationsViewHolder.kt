package com.example.pcconfigurator.Presentation.Adapters.ViewHolders

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pcconfigurator.Data.Models.Configuration
import com.example.pcconfigurator.Presentation.Fragments.IClickListenerCallBack
import com.example.pcconfigurator.R

class ConfigurationsViewHolder(var itemView: View,var callBack: IClickListenerCallBack) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private val title = itemView.findViewById<TextView>(R.id.configuration_title)
    private val accessoriesQuantity = itemView.findViewById<TextView>(R.id.accessories_quantity)
    private val totalprice = itemView.findViewById<TextView>(R.id.total_price)

    init {
        itemView.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun initData(configuration: Configuration) {
        title.text = configuration.title.toString()
        accessoriesQuantity.text =
            configuration.accessoryQuantity.toString() + "/" + configuration.requiredQuantity.toString()
        totalprice.text = configuration.totalPrice.toString() + "₽"

    }

    override fun onClick(v: View?) {
        callBack.itemClick(adapterPosition)
    }
}