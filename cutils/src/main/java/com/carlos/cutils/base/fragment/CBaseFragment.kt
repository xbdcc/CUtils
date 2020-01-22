package com.carlos.cutils.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by Carlos on 2020-01-15.
 */
abstract class CBaseFragment : Fragment() {

    abstract fun layoutId(): Int

    abstract fun initView(view: View)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(layoutId(), container, false)
        initView(view)
        return view
    }

}