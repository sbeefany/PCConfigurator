package com.example.pcconfigurator.Presentation.Fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.pcconfigurator.Data.Models.Configuration
import java.lang.NullPointerException

class MyFragmentFactory: FragmentFactory() {

    var configuration:Configuration?=null

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        when (loadFragmentClass(classLoader, className)) {
            ConfigurationDetailsAccessoriesFragment::class.java -> {
                if(configuration!=null)
                   return ConfigurationDetailsAccessoriesFragment(configuration!!)
                else
                    throw NullPointerException("SET CONFIGURATION!")
            }
            ConfigurationDetailsPageFragment::class.java->{
                if(configuration!=null)
                    return ConfigurationDetailsPageFragment(configuration!!)
                else
                    throw NullPointerException("SET CONFIGURATION!")
            }
            ConfigurationDetailsInfoFragment::class.java->{
                if(configuration!=null)
                    return ConfigurationDetailsInfoFragment(configuration!!)
                else
                    throw NullPointerException("SET CONFIGURATION!")
            }
            else -> return super.instantiate(classLoader, className)
        }
    }
}