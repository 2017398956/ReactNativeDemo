package com.example.reactnativedemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import personal.nfl.testlibrary.TestActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        btn_open_react_native.setOnClickListener {
            startActivity(Intent(this, MyReactActivity::class.java))
        }
        btn_test_activity.setOnClickListener {
            startActivity(Intent(this , TestActivity::class.java))
        }
    }
}