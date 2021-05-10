package com.example.pcconfigurator.Presentation.Adapters

import Accessory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pcconfigurator.Data.Models.Configuration
import com.example.pcconfigurator.Presentation.Adapters.DiffUtils.DiffUtilsConfigurationDetailsAccessories
import com.example.pcconfigurator.Presentation.Adapters.DiffUtils.DiffUtilsConfigurationsCallBack
import com.example.pcconfigurator.Presentation.Adapters.ViewHolders.ConfigurationDetailsAccessoriesViewHolder
import com.example.pcconfigurator.R

class SearchAccessoriesAdapter(var accessories: List<Accessory>) :
    RecyclerView.Adapter<ConfigurationDetailsAccessoriesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ConfigurationDetailsAccessoriesViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_configuration_details, parent, false)
        return ConfigurationDetailsAccessoriesViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ConfigurationDetailsAccessoriesViewHolder,
        position: Int
    ) {
        holder.initData(accessories[position])
    }

    override fun getItemCount() = accessories.size

    fun updateList(accessories: List<Accessory>) {
        val configurationDiffUtil =
            DiffUtilsConfigurationDetailsAccessories(accessories, this.accessories)
        val diffResult = DiffUtil.calculateDiff(configurationDiffUtil)
        this.accessories = accessories
        diffResult.dispatchUpdatesTo(this)
    }
}