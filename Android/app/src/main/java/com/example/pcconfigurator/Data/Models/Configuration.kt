package com.example.pcconfigurator.Data.Models

import Accessory
import java.util.*

class Configuration(var id: UUID, var accessories: List<Accessory>) {



    val totalPrice: Int
        get() = accessories.sumOf { it.price }

    val accessoryQuantity: Int get() = accessories.size

    val requiredQuantity: Int get() = 8
}