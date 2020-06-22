package com.dasbikash.super_activity_example

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import com.dasbikash.super_activity.SingleFragmentSuperActivity


class MainActivity : SingleFragmentSuperActivity() {

    override fun getLoneFrameId(): Int = R.id.lone_frame

    override fun getLayoutID(): Int = R.layout.activity_single_fragment

    override fun getDefaultFragment() = FragmentFirst()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}

