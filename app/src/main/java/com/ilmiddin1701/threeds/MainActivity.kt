package com.ilmiddin1701.threeds

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var handler: Handler
    var isChecked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = Handler(Looper.getMainLooper())
        onBackPressedDispatcher.addCallback(onBackPressedCallBack)
    }

    val runnable = object : Runnable{
        override fun run() {
            isChecked = false
            handler.postDelayed(this,2000)
        }
    }

    private val onBackPressedCallBack = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            if (!isChecked) {
                Toast.makeText(this@MainActivity, "Chiqish uchun yana bir marta bosing", Toast.LENGTH_SHORT).show()
                isChecked = true
                handler.postDelayed(runnable, 2000)
            } else {
                finish()
            }
        }
    }
}