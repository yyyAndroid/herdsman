package com.arcfun.afl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.arcfun.aflbroker.AflBroker
import com.arcfun.aflbroker.AflStartBrokerListener
import com.arcfun.aflbroker.AflStopBrokerListener
import com.arcfun.aflbroker.IBroker
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 上传订单可靠性
 */
class MainActivity : AppCompatActivity() {

    private val TAG = "com.arcfun.javademo"
    private lateinit var mViewModel: OutLibViewModel
    private var mBroker: IBroker? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e(TAG, "onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //创建ViewModel
        mViewModel = ViewModelProviders.of(this).get(OutLibViewModel::class.java)

        start_server.setOnClickListener {
//            var intent = Intent(MainActivity@ this, TestService::class.java).apply {
//                putExtra("EXTRA_PARAM_WASTEREMOVALNO", 1)
//            }
            var intent = Intent(MainActivity@ this, TestService::class.java).let {
//                null
//            }
                this.startService(intent)
            }
        }

            start.setOnClickListener {
                if (mBroker == null)
                    mBroker = AflBroker()
                mBroker?.setStartListener(object : AflStartBrokerListener {
                    override fun fail(msg: String) {
                        Log.i(TAG, "start server fail ${msg}")
                        runOnUiThread {
                            content.setText("服务启动失败${msg}")
                            imageview.setImageResource(R.mipmap.server_no_running)
                        }
                    }

                    override fun success() {
                        Log.i(TAG, "start server success")
                        runOnUiThread {
                            imageview.setImageResource(R.mipmap.server_running)
                            content.setText("服务已启动")
                            desc.setText(DeviceUtils.getIPAddress(baseContext))
                        }
                    }

                })

                mBroker?.setStopListener(object : AflStopBrokerListener {
                    override fun fail(msg: String) {
                        Log.i(TAG, "start server fail ${msg}")
                        runOnUiThread {
                            content.setText("服务关闭失败${msg}")
                            imageview.setImageResource(R.mipmap.server_no_running)
                        }
                    }

                    override fun success() {
                        Log.i(TAG, "start server success")
                        runOnUiThread {
                            imageview.setImageResource(R.mipmap.server_no_running)
                            content.setText("服务关闭成功")

                        }
                    }

                })
                imageview.setImageResource(R.mipmap.server_init)
                content.setText("服务启动中。。。。")
                mBroker?.startServer()
            }

            stop.setOnClickListener {
                mBroker?.stopServer()
            }
        }

        override fun onResume() {
            super.onResume()
            Log.e(TAG, "onResume()")
        }

        override fun onPause() {
            super.onPause()
            Log.e(TAG, "onPause()")
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.e(TAG, "onDestory()")
        }
}