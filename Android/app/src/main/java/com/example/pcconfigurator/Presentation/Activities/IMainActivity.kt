package com.example.pcconfigurator.Presentation.Activities

import androidx.fragment.app.Fragment
import com.example.pcconfigurator.Presentation.Presenters.SearchAccessoriesPresenter

interface IMainActivity {

    fun changeFragment(fragment: Fragment,tag:String)

    fun changeTitle(tittle: String)

    fun visibilitySpinner(boolean: Boolean, serchPresenter: SearchAccessoriesPresenter)




}