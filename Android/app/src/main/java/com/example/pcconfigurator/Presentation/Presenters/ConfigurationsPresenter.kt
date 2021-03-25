package com.example.pcconfigurator.Presentation.Presenters

import com.example.pcconfigurator.Data.ConfigurationsRepository
import com.example.pcconfigurator.Presentation.Fragments.IConfigurationsView

class ConfigurationsPresenter() {

    var view: IConfigurationsView?=null

    fun getConfigurations() {

        val configurations = ConfigurationsRepository.getConfigurations()
        if(configurations.isNotEmpty()){
            view?.showConfigurations(configurations)
        }else{
            view?.showWindowWithoutConfigurations()
        }
    }

}