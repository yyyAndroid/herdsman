package com.arcfun.afl

import android.app.Application
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.arcfun.library.workmanager.test.AhsWorkManager
import com.arcfun.library.workmanager.test.TestWorker
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity2 : AppCompatActivity() {
    private val TAG = "MainActivity2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)



        open_blue.setOnClickListener {
            val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivity(intent)
        }

        is_link.setOnClickListener {
            Log.d(TAG, "" + BluetoothAdapter.getDefaultAdapter()!!.isEnabled)
        }

        apply_work.setOnClickListener {
            AhsWorkManager.getInstance()
                .applyOneTimeWork(TestWorker::class.java, "TestWork", mapOf())
        }

        print_work.setOnClickListener {
            AhsWorkManager.getInstance().printWorkInfo("TestWork")
        }

        init_work.setOnClickListener {
            AhsWorkManager.getInstance().init(this)

        }
    }
}