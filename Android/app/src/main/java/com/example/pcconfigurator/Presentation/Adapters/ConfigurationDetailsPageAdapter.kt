package com.example.pcconfigurator.Presentation.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pcconfigurator.Presentation.Fragments.ConfigurationDetailsAccessoriesFragment
import com.example.pcconfigurator.Presentation.Fragments.MyFragmentFactory

class ConfigurationDetailsPageAdapter(var fm: FragmentManager, var fragments: List<Fragment>) :
    FragmentPagerAdapter(fm) {

    private var tabTitles = listOf<String>("Информация","Комплектующие")
    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles.get(position)
    }


}