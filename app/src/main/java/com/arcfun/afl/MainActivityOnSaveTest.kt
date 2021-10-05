package com.arcfun.afl

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap


/**
 * 对Activity onSaveInstance 与 Fragment Binding进行测试验证
 */
class MainActivityOnSaveTest : AppCompatActivity() {
    private val TAG = "TestOnSaveInstance"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_on_save_test)
        Log.d(TAG, "onCreate")
        if (savedInstanceState != null && savedInstanceState.getSerializable(TAG) != null) {
            val exceptionSet = savedInstanceState.getSerializable(TAG) as Map<String, Int>?
            Log.d(TAG, " onCreate  ${exceptionSet.toString()}")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val random = getExceptionSet()
        Log.d(TAG, "onSaveInstanceState  ${random.toString()}")
        outState.putSerializable(TAG, random)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestory()")
    }


    fun getExceptionSet(): LinkedHashMap<String, Int> {
        var map = LinkedHashMap<String, Int>()
        map.put("test", Random().nextInt(100))
        return map
    }
}