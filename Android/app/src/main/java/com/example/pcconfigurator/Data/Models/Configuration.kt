package com.example.pcconfigurator.Data.Models

import Accessory
import java.util.*

data class Configuration(var id: UUID, var accessories: List<Accessory>, var title:String) {



    val totalPrice: Int
        get() = accessories.sumOf { it.price }

    val accessoryQuantity: Int get() = accessories.size

    val requiredQuantity: Int get() = 8//переделать

}