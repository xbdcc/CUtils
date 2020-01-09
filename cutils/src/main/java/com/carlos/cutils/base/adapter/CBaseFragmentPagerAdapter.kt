package com.carlos.cutils.base.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Github: https://github.com/xbdcc/.
 * Created by caochang on 2016/4/15.
 */
class CBaseFragmentPagerAdapter(fm: FragmentManager, private val mFragments: ArrayList<Fragment>) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }
}
