package com.carlos.cutils.base.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.*

/**
 * Github: https://github.com/xbdcc/.
 * Created by caochang on 2016/4/18.
 */
class CBaseMyPagerAdapter : FragmentPagerAdapter {

    private var mFragments: MutableList<Fragment>
    private var mFragmentTitles: MutableList<String>

    constructor(fm: FragmentManager) : super(fm) {
        mFragments = ArrayList()
        mFragmentTitles = ArrayList()
    }

    constructor(
        fm: FragmentManager,
        list: MutableList<Fragment>,
        strings: MutableList<String>
    ) : super(fm) {
        mFragments = list
        mFragmentTitles = strings
    }

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