package com.hpr.becuniversity.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.view.View
import com.hpr.becuniversity.fragments.Tab1AnalyzeFragment

class PageAdapterAnalyzeActivity : FragmentPagerAdapter {

    constructor(fm: FragmentManager?) : super(fm)


    override fun getItem(position: Int): Fragment {
       return Tab1AnalyzeFragment.newInstance("")
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {


        return getNameFragment(position)
    }

    private fun getNameFragment(position: Int): CharSequence? {

        if (position == 0)
            return "Proposta"
        else if (position == 1)
            return "Necessidade"

        return ""
    }


}