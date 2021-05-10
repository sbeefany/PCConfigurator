package com.example.pcconfigurator.Presentation.Adapters.DiffUtils

import Accessory
import androidx.recyclerview.widget.DiffUtil
import com.example.pcconfigurator.Data.Models.Configuration

class DiffUtilsConfigurationDetailsAccessories (
    private val newList: List<Accessory>,
    private val oldList: List<Accessory>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList[newItemPosition] == oldList[oldItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList[newItemPosition] == oldList[oldItemPosition]
    }
}