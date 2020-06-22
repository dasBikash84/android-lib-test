package com.dasbikash.async_manager_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dasbikash.android_extensions.startActivity
import kotlinx.android.synthetic.main.activity_ex_async_manager.*

class ActivityExampleAsyncManager : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex_async_manager)

        btn_image_demo.setOnClickListener {
            startActivity(ActivityImageDemo::class.java)
        }

        btn_toast_demo.setOnClickListener {
            startActivity(ActivityCounterDemo::class.java)
        }

    }
}
