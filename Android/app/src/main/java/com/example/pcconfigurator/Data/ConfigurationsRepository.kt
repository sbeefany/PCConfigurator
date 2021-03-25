package com.example.pcconfigurator.Data

import Accessory
import com.example.pcconfigurator.Data.Models.Configuration
import com.example.pcconfigurator.Data.Network.Common
import com.example.pcconfigurator.Data.Network.ConfigurationsApi
import java.util.*

object ConfigurationsRepository : IConfigurationsRepository {

    private val api: ConfigurationsApi = Common.retrofitApi
    val accessories: List<Accessory> = listOf(
        Accessory("Name", "Vendor", UUID.randomUUID(), 150),
        Accessory("Name", "Vendor", UUID.randomUUID(), 150),
        Accessory("Name", "Vendor", UUID.randomUUID(), 150),
        Accessory("Name", "Vendor", UUID.randomUUID(), 150),
        Accessory("Name", "Vendor", UUID.randomUUID(), 150),
        Accessory("Name","Vendor", UUID.randomUUID(),150),
        Accessory("Name","Vendor", UUID.randomUUID(),150)
    )
    val configurationsList = listOf(
        Configuration(UUID.randomUUID(), accessories),
        Configuration(UUID.randomUUID(), accessories),
        Configuration(UUID.randomUUID(), accessories),
        Configuration(UUID.randomUUID(), accessories),
        Configuration(UUID.randomUUID(), accessories)
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