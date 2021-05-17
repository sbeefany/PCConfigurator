package com.example.pcconfigurator.Presentation.Fragments

import com.example.pcconfigurator.Data.Models.Configuration

interface ConfigurationDetailsView {

    fun showConfiguration(configuration: Configuration)
}