package com.example.pcconfigurator.Domain

import Accessory


import com.example.pcconfigurator.Data.ConfigurationsRepository
import com.example.pcconfigurator.Data.Models.Configuration
import java.lang.NullPointerException
import java.util.*

object ConfigurationInteractor {

    var currentConfiguration: Configuration? = null
    val configurationRepository: ConfigurationsRepository = ConfigurationsRepository


    fun addAccessory(accessory: Accessory): Configuration {
        currentConfiguration?.let {
            val newList = mutableListOf<Accessory>()
            newList.addAll(it.accessories)
            newList.add(accessory)
            it.accessories=newList
            return it
        }
        throw NullPointerException("SET CONFIGURATION")

    }

    fun deleteAccessory(accessory: Accessory): Configuration {
        currentConfiguration?.let {
            val newList = mutableListOf<Accessory>()
            newList.addAll(it.accessories)
            newList.remove(accessory)
            it.accessories=newList
            return it
        }
        throw NullPointerException("SET CONFIGURATION")
    }

    fun getAllConfigurations(): List<Configuration> = configurationRepository.getConfigurations()

    fun getAllConfigurationsById(id: UUID): Configuration =
        configurationRepository.getConfiguration(id)
}