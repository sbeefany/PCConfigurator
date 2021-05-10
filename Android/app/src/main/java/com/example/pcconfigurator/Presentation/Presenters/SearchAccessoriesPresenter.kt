package com.example.pcconfigurator.Presentation.Presenters

import com.example.pcconfigurator.Data.AccessoriesRepository
import com.example.pcconfigurator.Presentation.Fragments.ISearchAccessories

class SearchAccessoriesPresenter(var view: ISearchAccessories?) {


    fun getAccessories(type: String) {

        val accessories = AccessoriesRepository.getAccessoriesByType(type)

        view?.showAccessories(accessories)

    }
}