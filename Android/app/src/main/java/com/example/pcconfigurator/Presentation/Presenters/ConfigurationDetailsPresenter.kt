package com.example.pcconfigurator.Presentation.Presenters

import Accessory
import android.os.Parcelable
import com.example.pcconfigurator.Data.Models.Configuration
import com.example.pcconfigurator.Domain.ConfigurationInteractor
import com.example.pcconfigurator.Presentation.Fragments.ConfigurationDetailsView

class ConfigurationDetailsPresenter(var view: ConfigurationDetailsView?)  {


    fun addAccessory(accessory: Accessory) {
        view?.showConfiguration(ConfigurationInteractor.addAccessory(accessory))
    }

    fun deleteAccessory(accessory: Accessory) {
        view?.showConfiguration(ConfigurationInteractor.deleteAccessory(accessory))
    }

    fun setUpCurrentConfiguration(configuration: Configuration) {
        ConfigurationInteractor.currentConfiguration = configuration
        view?.showConfiguration(configuration)
    }
}
