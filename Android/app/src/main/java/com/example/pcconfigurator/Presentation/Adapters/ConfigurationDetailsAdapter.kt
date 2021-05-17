package com.example.pcconfigurator.Presentation.Adapters

import Accessory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pcconfigurator.Presentation.Adapters.DiffUtils.DiffUtilsConfigurationDetailsAccessories
import com.example.pcconfigurator.Presentation.Adapters.ViewHolders.ConfigurationDetailsAccessoriesViewHolder
import com.example.pcconfigurator.Presentation.Adapters.ViewHolders.ConfigurationDetailsHeadlineViewHolder
import com.example.pcconfigurator.Presentation.Adapters.ViewHolders.ConfigurationDetailsImageViewHolder
import com.example.pcconfigurator.Presentation.Adapters.ViewHolders.ConfigurationsViewHolder
import com.example.pcconfigurator.Presentation.Fragments.IClickListenerCallBack
import com.example.pcconfigurator.R

class ConfigurationDetailsAdapter(
    var accessories: List<Accessory>,
    var callBack: IClickListenerCallBack,
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_image_configuration_details, parent, false)
                ConfigurationDetailsImageViewHolder(view)
            }
            1 -> {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_headline_configuration_details, parent, false)
                ConfigurationDetailsHeadlineViewHolder(view)
            }
            else -> {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_configuration_details, parent, false)
                ConfigurationDetailsAccessoriesViewHolder(view, callBack)
            }
        }
    }

    override fun getItemCount() = accessories.size + 2


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ConfigurationDetailsAccessoriesViewHolder)
            holder.initData(accessories[position - 2])
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun updateList(accessories: List<Accessory>) {
        val configurationDiffUtil =
            DiffUtilsConfigurationDetailsAccessories(accessories, this.accessories)
        val diffResult = DiffUtil.calculateDiff(configurationDiffUtil)
        val newList = mutableListOf<Accessory>()
        newList.addAll(accessories)
        this.accessories = newList
        diffResult.dispatchUpdatesTo(this)
    }
}