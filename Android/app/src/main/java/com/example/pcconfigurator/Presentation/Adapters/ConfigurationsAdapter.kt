package com.example.pcconfigurator.Presentation.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pcconfigurator.Data.Models.Configuration
import com.example.pcconfigurator.Presentation.Adapters.DiffUtils.DiffUtilsConfigurationsCallBack
import com.example.pcconfigurator.Presentation.Adapters.ViewHolders.ConfigurationsViewHolder
import com.example.pcconfigurator.Presentation.Fragments.IClickListenerCallBack
import com.example.pcconfigurator.R

class ConfigurationsAdapter(var configurations: List<Configuration>,private val callBack: IClickListenerCallBack) : RecyclerView.Adapter<ConfigurationsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConfigurationsViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_confuration,parent,false)
        return ConfigurationsViewHolder(view,callBack)
    }

    override fun onBindViewHolder(holder: ConfigurationsViewHolder, position: Int) {
        holder.initData(configurations.get(position))
    }

    override fun getItemCount(): Int {
        return configurations.size
    }

    fun updateList(configurations:List<Configuration>){
        val configurationDiffUtil:DiffUtilsConfigurationsCallBack = DiffUtilsConfigurationsCallBack(configurations,this.configurations)
        val diffResult = DiffUtil.calculateDiff(configurationDiffUtil)
        this.configurations = configurations;
        diffResult.dispatchUpdatesTo(this)
    }
}