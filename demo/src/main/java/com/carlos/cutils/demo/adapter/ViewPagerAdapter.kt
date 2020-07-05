package com.carlos.cutils.demo.adapter

import android.view.View
import android.widget.ImageView
import com.carlos.cutils.base.adapter.CBaseViewPagerAdapter
import com.carlos.cutils.demo.R

/**
 * Created by Carlos on 2020/4/16.
 */
class ViewPagerAdapter(mList: List<Int>) : CBaseViewPagerAdapter(mList) {

    override fun initView(itemView: View, position: Int) {
        val imageView = itemView.findViewById<ImageView>(R.id.imageview)
        imageView.setImageResource(mList[position] as Int)
    }

    override fun layoutId(): Int {
        return R.layout.item_viewpager
    }

}