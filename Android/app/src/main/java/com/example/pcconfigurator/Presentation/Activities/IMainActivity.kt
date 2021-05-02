package com.example.pcconfigurator.Presentation.Activities

import androidx.fragment.app.Fragment

interface IMainActivity {

    fun changeFragment(fragment:Fragment)

    fun changeTitle(tittle:String)

}