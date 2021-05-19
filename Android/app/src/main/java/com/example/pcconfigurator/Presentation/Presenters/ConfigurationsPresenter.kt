package com.example.pcconfigurator.Presentation.Presenters

import com.example.pcconfigurator.Data.ConfigurationsRepository
import com.example.pcconfigurator.Domain.ConfigurationInteractor
import com.example.pcconfigurator.Presentation.Fragments.IConfigurationsView

class ConfigurationsPresenter(var view: IConfigurationsView?) {


    fun createConfiguration(name:String){
        val configurations = ConfigurationInteractor.createConfiguration(name)
        if(configurations.isNotEmpty()){
            view?.showConfigurations(configurations)
        }else{
            view?.showWindowWithoutConfigurations()
        }
    }

    fun getConfigurations() {

        val configurations = ConfigurationInteractor.getAllConfigurations()
        if(configurations.isNotEmpty()){
            view?.showConfigurations(configurations)
        }else{
            view?.showWindowWithoutConfigurations()
        }
    }

}