package com.example.pcconfigurator.Presentation.Adapters.ViewHolders

import Accessory
import Accessory.*
import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pcconfigurator.Presentation.Fragments.IClickListenerCallBack
import com.example.pcconfigurator.R

class SearchAccessoriesViewHolder(
    itemView: View,
    val callBack: IClickListenerCallBack,
    context: Context?,
) :
    RecyclerView.ViewHolder(itemView) {

    private val imageView: ImageView = itemView.findViewById(R.id.accessory_image)
    private val name: TextView = itemView.findViewById(R.id.name_accessory)
    private val vendor: TextView = itemView.findViewById(R.id.vendor_accessory)
    private val price: TextView = itemView.findViewById(R.id.price_accessory)
    private val title: TextView = itemView.findViewById(R.id.title_accessory)
    private val resources = context?.resources

    init {
        itemView.setOnClickListener {
            callBack.itemClick(adapterPosition)
        }
    }

    @SuppressLint("SetTextI18n")
    fun initViews(accessory: Accessory) {
        name.text = accessory.name
        vendor.text = accessory.vendor
        price.text = accessory.price.toString() + "₽"

        when (accessory) {
            is MotherBoard -> {
                title.text = "Материнская плата"
                if (resources != null)
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.ic_motherboard))
                else
                    imageView.visibility = View.GONE

            }
            is Cpu -> {
                title.text = "Процессор"
                if (resources != null)
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.ic_cpu))
                else
                    imageView.visibility = View.GONE
            }
            is Gpu -> {
                title.text = "Видеокарта"
                if (resources != null)
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.ic_gpu))
                else
                    imageView.visibility = View.GONE
            }
            is Ram -> {
                title.text = "Оперативная память"
                if (resources != null)
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.ic_ram))
                else
                    imageView.visibility= View.GONE
            }
            is Disk -> {
                title.text = "Устройство хранения"
                if (resources != null)
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.ic_harddisk))
                else
                    imageView.visibility= View.GONE
            }
            is PowerSupply -> {
                title.text = "Блок питания"
                if (resources != null)
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.ic_power_supply))
                else
                    imageView.visibility= View.GONE
            }
            is Cooler -> {
                title.text = "Устрйоство охлаждения"
                if (resources != null)
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.ic_cooler))
                else
                    imageView.visibility= View.GONE
            }
            is ComputerCase -> {
                title.text = "Корпус"
                if (resources != null)
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.ic_computer_case))
                else
                    imageView.visibility= View.GONE
            }
        }
    }
}