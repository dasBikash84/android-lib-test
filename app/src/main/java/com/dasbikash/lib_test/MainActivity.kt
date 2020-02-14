package com.dasbikash.lib_test

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.dasbikash.android_image_utils.ImageUtils
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val url =
        "https://img.thedailybeast.com/image/upload/c_crop,d_placeholder_euli9k,h_1687,w_3000,x_0,y_0/dpr_1.5/c_limit,w_1044/fl_lossy,q_auto/v1580496583/200130-TRUDO-Bernie-Sanders-Surrogate-Dilemma-tease_hvz9ur"

    private val url2 =
        "https://cdn.vox-cdn.com/thumbor/cVNs6wxzdPPHSoF-cuPo6COWONo=/0x0:3276x2184/920x613/filters:focal(1700x827:2224x1351):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/63077577/1095078290.jpg.0.jpg"

    private val url3 =
        "https://image.cnbcfm.com/api/v1/image/106207101-1572264314938rts2t5ab.jpg?v=1572264369"

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        lifecycleScope.launch(Dispatchers.IO) {
//            try {
//                ImageUtils.getBitmapFromUrl(url).apply {
//                    runOnUiThread { image1.setImageBitmap(this) }
//                }
//            } catch (ex: Throwable) {
//                ex.printStackTrace()
//            }
//        }
        lifecycleScope.launch {
            try {
                ImageUtils.getBitmapFromUrlSuspended(url2).apply {
                    runOnUiThread { image2.setImageBitmap(this) }
                }
            } catch (ex: Throwable) {
                ex.printStackTrace()
            }
        }
        /*ImageUtils.getBitmapFromUrlObservable(url3)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { it.printStackTrace() }
            .subscribe(object : Observer<Bitmap> {
                override fun onComplete() {}

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: Bitmap) {
                    image3.setImageBitmap(t)
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            })*/

//        lifecycleScope.launch {
//            ImageUtils.fetchImage(url, "test", this@MainActivity).apply {
//                println("Image1 location: $this")
//            }
//        }
    }
}
