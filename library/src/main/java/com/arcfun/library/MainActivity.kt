package com.arcfun.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.arcfun.library.single.SingletonnEnum
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SingletonnEnum.INSTANCE.doSomething()


        LayoutInflater.from(this).inflate(R.layout.activity_main, null)


    }
}