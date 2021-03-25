package com.example.pcconfigurator.Presentation.Adapters.DiffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.pcconfigurator.Data.Models.Configuration

class DiffUtilsConfigurationsCallBack(
    val newList: List<Configuration>,
    val oldList: List<Configuration>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList.get(newItemPosition)==oldList.get(oldItemPosition)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList.get(newItemPosition).equals(oldList.get(oldItemPosition))
    }
}