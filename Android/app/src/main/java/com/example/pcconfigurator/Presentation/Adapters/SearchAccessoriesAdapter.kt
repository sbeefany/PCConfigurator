package com.example.pcconfigurator.Presentation.Adapters

import Accessory
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pcconfigurator.Data.Models.Configuration
import com.example.pcconfigurator.Presentation.Adapters.DiffUtils.DiffUtilsConfigurationDetailsAccessories
import com.example.pcconfigurator.Presentation.Adapters.DiffUtils.DiffUtilsConfigurationsCallBack
import com.example.pcconfigurator.Presentation.Adapters.ViewHolders.ConfigurationDetailsAccessoriesViewHolder
import com.example.pcconfigurator.Presentation.Adapters.ViewHolders.SearchAccessoriesViewHolder
import com.example.pcconfigurator.Presentation.Fragments.IClickListenerCallBack
import com.example.pcconfigurator.R

class SearchAccessoriesAdapter(
    var accessories: List<Accessory>,
    val callBack: IClickListenerCallBack,
    val context: Context?,
) :
    RecyclerView.Adapter<SearchAccessoriesViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SearchAccessoriesViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search_accessories, parent, false)
        return SearchAccessoriesViewHolder(view, callBack, context)
    }

    override fun onBindViewHolder(
        holder: SearchAccessoriesViewHolder,
        position: Int,
    ) {
        holder.initViews(accessories[position])
    }

    override fun getItemCount() = accessories.size

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