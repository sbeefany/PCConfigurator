package com.example.pcconfigurator.Data

import Accessory
import com.example.pcconfigurator.Data.AccessoriesRepository.allAccessories
import com.example.pcconfigurator.Data.Models.*
import com.example.pcconfigurator.Data.Network.Common
import com.example.pcconfigurator.Data.Network.ConfigurationsApi
import java.util.*

object ConfigurationsRepository : IConfigurationsRepository {

    private val api: ConfigurationsApi = Common.retrofitApi


    private val configurationsList = mutableListOf<Configuration>(
        Configuration(UUID.randomUUID(),
            listOf(allAccessories[0], allAccessories[10],
                allAccessories[5], allAccessories[15]),
            "1 конфигурация",
            UUID.fromString("be0b6c37-f50d-4511-9e3b-31cff4de6b11")),
        Configuration(UUID.randomUUID(),
            listOf(allAccessories[0], allAccessories[10],
                allAccessories[5], allAccessories[15]),
            "2 конфигурация",
            UUID.fromString("be0b6c37-f50d-4511-9e3b-31cff4de6b11")),
        Configuration(UUID.randomUUID(),
            listOf(allAccessories[0], allAccessories[10],
                allAccessories[5], allAccessories[15]),
            "3 конфигурация",
            UUID.fromString("be0b6c37-f50d-4511-9e3b-31cff4de6b11")),
        Configuration(UUID.randomUUID(),
            listOf(allAccessories[0], allAccessories[10],
                allAccessories[5], allAccessories[15]),
            "4 конфигурация",
            UUID.fromString("be0b6c37-f50d-4511-9e3b-31cff4de6b11")),
        Configuration(UUID.randomUUID(),
            listOf(allAccessories[0], allAccessories[10],
                allAccessories[5], allAccessories[15]),
            "5 конфигурация",
            UUID.fromString("be0b6c37-f50d-4511-9e3b-31cff4de6b11")),
        Configuration(UUID.randomUUID(),
            emptyList(),
            "6 конфигурация",
            UUID.fromString("be0b6c37-f50d-4511-9e3b-31cff4de6b11"))
    )

    override fun getConfigurations(): List<Configuration> {
        return configurationsList
    }

    override fun getConfiguration(id: UUID): Configuration {
        TODO("Not yet implemented")
    }

    override fun saveConfiguration(configuration: Configuration) {
        configurationsList.add(configuration)
    }

    override fun getAllConfigurationByUser(userId: UUID) {
        TODO("Not yet implemented")
    }

}