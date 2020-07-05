package com.carlos.cutils.demo.fragment

import android.view.View
import androidx.viewpager.widget.ViewPager
import com.carlos.cutils.demo.R
import com.carlos.cutils.demo.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_viewpager.*

/**
 * Created by Carlos on 2020/4/16.
 */
class ViewPagerFragment : BaseFragment(R.layout.fragment_viewpager) {

    private val resId = listOf(R.mipmap.xiaobudian, R.mipmap.ic_launcher, R.mipmap.xiaobudian)

    override fun initView(view: View) {
        super.initView(view)
        val viewPagerAdapter = ViewPagerAdapter(resId)
        viewpager.adapter = viewPagerAdapter
        setTitle(0)
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                setTitle(position)
            }
        })
    }

    private fun setTitle(position: Int) {
        val text = "${position + 1}/${resId.size}"
        title.text = text
    }
}