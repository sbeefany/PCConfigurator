package com.example.pcconfigurator.Data

import Accessory
import com.example.pcconfigurator.Data.Models.Configuration
import java.util.*

interface IConfigurationsRepository {
    fun getConfigurations(): List<Configuration >

    fun getConfiguration(id:UUID):Configuration

    fun saveConfiguration(configuration: Configuration)
}