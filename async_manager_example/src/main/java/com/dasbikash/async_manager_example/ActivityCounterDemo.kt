package com.dasbikash.async_manager_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dasbikash.android_extensions.hide
import com.dasbikash.android_extensions.show
import com.dasbikash.async_manager.AsyncTaskHandler
import com.dasbikash.async_manager.AsyncTaskManager
import kotlinx.android.synthetic.main.activity_counter_demo.*

class ActivityCounterDemo : AppCompatActivity() {

    lateinit var taskHandler: AsyncTaskHandler<*>
    private var secCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter_demo)
        btn_stop_counter.hide()
        updateDisplay()
        btn_start_counter.setOnClickListener {
            enqueueTask()
            btn_start_counter.hide()
            btn_stop_counter.show()
        }
        btn_stop_counter.setOnClickListener {
            taskHandler.cancelTask()
            btn_start_counter.show()
            btn_stop_counter.hide()
        }
    }

    private fun enqueueTask(){
        taskHandler = AsyncTaskManager.addTask(
            task = {
                Thread.sleep(1000)
            },
            doOnSuccess = {
                secCount++
                updateDisplay()
                enqueueTask()
            },
            lifecycleOwner = this
        )
    }

    private fun updateDisplay() {
        println(secCount)
        tv_counter_time.setText("Counter running for ${secCount} seconds")
    }
}