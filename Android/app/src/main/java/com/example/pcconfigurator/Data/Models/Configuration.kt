package com.example.pcconfigurator.Data.Models

import Accessory
import com.example.pcconfigurator.Data.Network.NetworkDTO.ConfigurationDTO
import java.util.*

class Configuration(val id: UUID, val accessories: List<Accessory>) {



    val totalPrice: Int
        get() = accessories.sumOf { it.price }

    val accessoryQuantity: Int get() = accessories.size

    val requiredQuantity: Int get() = 8
}