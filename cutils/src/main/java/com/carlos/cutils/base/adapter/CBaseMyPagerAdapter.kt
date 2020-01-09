package com.carlos.cutils.base.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Github: https://github.com/xbdcc/.
 * Created by caochang on 2016/4/18.
 */
class CBaseMyPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager){

    var mFragments = ArrayList<Fragment>()
    var mFragmentTitles = ArrayList<String>()

    fun addFragment(fragment: Fragment, title: String) {
        mFragments.add(fragment)
        mFragmentTitles.add(title)
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitles[position]
    }
}