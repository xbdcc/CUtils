package com.carlos.cutils.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

/**
 * 引导页
 * Created by Carlos on 2020/4/16.
 */
abstract class CBaseViewPagerAdapter(open val mList: List<Any>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val context = container.context
        val itemView: View = LayoutInflater.from(context).inflate(layoutId(), container, false)
        initView(itemView, position)
        container.addView(itemView)
        return itemView
    }

    abstract fun layoutId(): Int

    abstract fun initView(itemView: View, position: Int)

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return mList.size
    }

}