package com.example.pcconfigurator.Presentation.Fragments

import com.example.pcconfigurator.Data.Models.Configuration

interface IConfigurationsView {

    fun showConfigurations(configurations:List<Configuration>)

    fun showWindowWithoutConfigurations()

    fun showError(message:String)

}