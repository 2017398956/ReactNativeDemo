package com.example.reactnativedemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.reactnativedemo.databinding.ActivityMainBinding
import personal.nfl.testlibrary.TestActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {
        binding.btnOpenReactNative.setOnClickListener {
            startActivity(Intent(this, MyReactActivity::class.java))
        }
        binding.btnTestActivity.setOnClickListener {
            startActivity(Intent(this, TestActivity::class.java))
        }
    }
}