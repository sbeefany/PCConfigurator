package com.example.pcconfigurator.Presentation.Fragments

import Accessory
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.pcconfigurator.Data.Models.Configuration
import java.lang.NullPointerException

class MyFragmentFactory : FragmentFactory() {

    var configuration: Configuration? = null
    var accessory: Accessory? = null

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        when (loadFragmentClass(classLoader, className)) {

            ConfigurationDetailsPageFragment::class.java -> {
                if (configuration != null)
                    return ConfigurationDetailsPageFragment(configuration!!)
                else
                    throw NullPointerException("SET CONFIGURATION!")
            }
            AccessoryDetailsFragment::class.java -> {
                if (accessory != null)
                    return AccessoryDetailsFragment(accessory!!)
                else
                    throw NullPointerException("SET Accessory!")
            }
            else -> return super.instantiate(classLoader, className)
        }
    }
}