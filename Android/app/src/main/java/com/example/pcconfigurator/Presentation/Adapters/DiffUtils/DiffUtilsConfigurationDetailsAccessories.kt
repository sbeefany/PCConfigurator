package com.example.pcconfigurator.Presentation.Adapters.DiffUtils

import Accessory
import androidx.recyclerview.widget.DiffUtil
import com.example.pcconfigurator.Data.Models.Configuration

class DiffUtilsConfigurationDetailsAccessories (
    val newList: List<Accessory>,
    val oldList: List<Accessory>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList.get(newItemPosition) == oldList.get(oldItemPosition)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList.get(newItemPosition).equals(oldList.get(oldItemPosition))
    }
}