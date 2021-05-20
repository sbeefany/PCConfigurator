package com.example.pcconfigurator.Presentation.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ComparisonSessionFragmentPagerAdapter(fm: FragmentManager, var fragments: List<Fragment>) :
    FragmentPagerAdapter(fm) {
    override fun getCount(): Int = fragments.size

    override fun getItem(position: Int): Fragment = fragments.get(position)

    override fun getPageTitle(position: Int): CharSequence? {
        return "" + position + 1 + " Конфигурация"
    }
}