package com.example.pcconfigurator.Data

import Accessory
import com.example.pcconfigurator.Data.AccessoriesRepository.allAccessories
import com.example.pcconfigurator.Data.Models.*
import com.example.pcconfigurator.Data.Network.Common
import com.example.pcconfigurator.Data.Network.ConfigurationsApi
import java.util.*

object ConfigurationsRepository : IConfigurationsRepository {

    private val api: ConfigurationsApi = Common.retrofitApi


   private val configurationsList = listOf(
        Configuration(UUID.randomUUID(), listOf(allAccessories[0], allAccessories[10],
            allAccessories[5], allAccessories[15]), "1 конфигурация"),
        Configuration(UUID.randomUUID(), listOf(allAccessories[0], allAccessories[10],
            allAccessories[5], allAccessories[15]), "2 конфигурация"),
        Configuration(UUID.randomUUID(), listOf(allAccessories[0], allAccessories[10],
            allAccessories[5], allAccessories[15]), "3 конфигурация"),
        Configuration(UUID.randomUUID(), listOf(allAccessories[0], allAccessories[10],
            allAccessories[5], allAccessories[15]), "4 конфигурация"),
        Configuration(UUID.randomUUID(), listOf(allAccessories[0], allAccessories[10],
            allAccessories[5], allAccessories[15]), "5 конфигурация"),
        Configuration(UUID.randomUUID(), emptyList(), "6 конфигурация")
    )

    override fun getConfigurations(): List<Configuration> {
        return configurationsList
    }

    override fun getConfiguration(id: UUID): Configuration {
        TODO("Not yet implemented")
    }

    override fun saveConfiguration(accessories: List<Accessory>) {
        TODO("Not yet implemented")
    }

}