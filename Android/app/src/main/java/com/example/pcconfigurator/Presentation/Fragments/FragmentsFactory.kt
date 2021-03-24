package com.example.pcconfigurator.Presentation.Fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.pcconfigurator.Data.ITestDataRepository

class FragmentsFactory(val repository: ITestDataRepository) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        when (loadFragmentClass(classLoader, className)) {
            PcConfiguratorStartPageFragment::class.java -> return PcConfiguratorStartPageFragment(
                repository
            )
            else -> return super.instantiate(classLoader, className)
        }
    }
}
