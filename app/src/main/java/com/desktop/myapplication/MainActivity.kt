package com.desktop.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start_job_button.setOnClickListener {
            JobUtils.getInstance()?.scheduleJob(this@MainActivity, System.currentTimeMillis().toInt())
        }
    }
}
