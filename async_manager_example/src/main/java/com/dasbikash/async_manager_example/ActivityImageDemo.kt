package com.dasbikash.async_manager_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dasbikash.android_extensions.hide
import com.dasbikash.android_extensions.show
import com.dasbikash.android_image_utils.ImageUtils
import com.dasbikash.async_manager.AsyncTaskManager
import kotlinx.android.synthetic.main.activity_image_demo.*

class ActivityImageDemo : AppCompatActivity() {

    private var firstImageViewActive = true

    private val urls = listOf<String>(
        "https://cdn.cnn.com/cnnnext/dam/assets/191230112940-05-bernie-sanders-lead-image-large-169.jpg",
        "https://cdn.cnn.com/cnnnext/dam/assets/200221172924-bernie-sanders-russia-interference-raw-sot-vpx-00000304-exlarge-169.jpg",
        "https://www.commondreams.org/sites/default/files/headlines/bernie_sanders_1_2_0.png",
        "https://thefederalist.com/wp-content/uploads/2020/02/Bernie-Sanders-998x665.jpg",
        "https://cdn.cnn.com/cnnnext/dam/assets/191125125525-bernie-sanders-1109-exlarge-169.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTBoTzhnKqlNwY_lBjz6DQzZlGw_gEE58sTpty4XtgaCuEr3vr_",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ1cdqyNI9l1FtyYBaDPVBkRGSkPUidzoqzwYtGLV7Lm3xTkjd7",
        "https://cdn.cfr.org/sites/default/files/styles/article_header_l_16x9_600px/public/image/2019/08/Bernie%20Sanders_0.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRVKKr9pNhwDR4RgoxcQJ1SgtAsiS-pgmJNIA&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTPUmSSQXxUDLIFO0Fg7xua_XHYVKqe9xF0AA&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSTuRZND8SiHW1pqNagp_8pDqaily39lIQY7g&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ-p19o-yiTfPdHXsCioGkRtyod8BQNeoVbqw&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcScl0imuoU9-UPMkFg_9xA_w_xVBFtMzPgAag&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSR0OhtCn5bLB-wGcgmsz5uatv5c6N8tQaWSg&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTxvmCYf_ncK4LPOEkoUS0jDfUbMDBMiV-OLA&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRS0cNgMLrtTvGmPNtKrJQpmS3UHQVsBL5zkw&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRmSjvNSDeh7Z1tj15qx5hxOQpOFQyDApC0sQ&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRJdjqHgq0dNzqX8bUzRXsMQKYDcffVAeM0Ow&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTCcx6Ye3cG3J3f4AobdJ8lw-hVSE8xO5Bnug&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRG5REm6wdf0PiefBiaSl7DX4Zhv-2RDhurjg&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTu6yNLaeOWX3YpI2MQHgZmhyB_LflPOpCQUQYDj4rfS6vS5pe0&s",
        "https://cdn.cnn.com/cnnnext/dam/assets/191230112940-05-bernie-sanders-lead-image-large-169.jpg",
        "https://cdn.cnn.com/cnnnext/dam/assets/200221172924-bernie-sanders-russia-interference-raw-sot-vpx-00000304-exlarge-169.jpg",
        "https://www.commondreams.org/sites/default/files/headlines/bernie_sanders_1_2_0.png",
        "https://thefederalist.com/wp-content/uploads/2020/02/Bernie-Sanders-998x665.jpg",
        "https://cdn.cnn.com/cnnnext/dam/assets/191125125525-bernie-sanders-1109-exlarge-169.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTBoTzhnKqlNwY_lBjz6DQzZlGw_gEE58sTpty4XtgaCuEr3vr_",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ1cdqyNI9l1FtyYBaDPVBkRGSkPUidzoqzwYtGLV7Lm3xTkjd7",
        "https://cdn.cfr.org/sites/default/files/styles/article_header_l_16x9_600px/public/image/2019/08/Bernie%20Sanders_0.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRVKKr9pNhwDR4RgoxcQJ1SgtAsiS-pgmJNIA&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTPUmSSQXxUDLIFO0Fg7xua_XHYVKqe9xF0AA&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSTuRZND8SiHW1pqNagp_8pDqaily39lIQY7g&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ-p19o-yiTfPdHXsCioGkRtyod8BQNeoVbqw&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcScl0imuoU9-UPMkFg_9xA_w_xVBFtMzPgAag&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSR0OhtCn5bLB-wGcgmsz5uatv5c6N8tQaWSg&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTxvmCYf_ncK4LPOEkoUS0jDfUbMDBMiV-OLA&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRS0cNgMLrtTvGmPNtKrJQpmS3UHQVsBL5zkw&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRmSjvNSDeh7Z1tj15qx5hxOQpOFQyDApC0sQ&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRJdjqHgq0dNzqX8bUzRXsMQKYDcffVAeM0Ow&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTCcx6Ye3cG3J3f4AobdJ8lw-hVSE8xO5Bnug&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRG5REm6wdf0PiefBiaSl7DX4Zhv-2RDhurjg&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTu6yNLaeOWX3YpI2MQHgZmhyB_LflPOpCQUQYDj4rfS6vS5pe0&s"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_demo)

        AsyncTaskManager.init()
        btn_stop_demo.hide()

        btn_start_demo.setOnClickListener {
            btn_start_demo.text = "Re-Start demo"
            startDemo()
            btn_stop_demo.show()
        }
        btn_stop_demo.setOnClickListener {
            AsyncTaskManager.clear()
            btn_stop_demo.hide()
        }
    }

    private fun startDemo() {
        urls.shuffled().asSequence().forEach {
            AsyncTaskManager.addTask(
                task = {
                    println("Will download: ${it}")
                    ImageUtils.getBitmapFromUrl(it).apply {
                        print("dl: ${it}")
                    }
                },
                doOnSuccess = {
                    println("doOnSuccess")
                    it?.let {
                        if (firstImageViewActive){
                            image1.setImageBitmap(it)
                        }else{
                            image2.setImageBitmap(it)
                        }

                        firstImageViewActive = !firstImageViewActive
                    }
                },
                doOnFailure = {
                    it?.printStackTrace()
                },
                lifecycleOwner = this
            )
        }
    }
}