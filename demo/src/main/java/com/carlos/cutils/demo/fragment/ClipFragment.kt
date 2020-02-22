package com.carlos.cutils.demo.fragment

import android.view.View
import com.carlos.cutils.demo.R
import com.carlos.cutils.extend.clipText
import com.carlos.cutils.extend.setClipText
import kotlinx.android.synthetic.main.fragment_clip.*

/**
 * Created by Carlos on 2020-02-20.
 */
class ClipFragment : BaseFragment(R.layout.fragment_clip) {

    override fun initView(view: View) {
        b_copy.setOnClickListener {
            et_copy.clipText()
        }
        b_paste.setOnClickListener {
            tv_paste.setClipText()
        }
    }

}