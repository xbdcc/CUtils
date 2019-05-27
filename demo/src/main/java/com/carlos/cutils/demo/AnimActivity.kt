package com.carlos.cutils.demo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Carlos on 2019-05-27.
 */
class AnimActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test11)
    }

    fun back(view: View) {
        finish()
        overridePendingTransition(R.anim.c_left_in, R.anim.c_left_in)
    }

}
