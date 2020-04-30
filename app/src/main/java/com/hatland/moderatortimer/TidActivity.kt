package com.hatland.moderatortimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class TidActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tid)
    }

    override fun onStart() {
        Log.i("Tid Activity", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i("Tid Activity", "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i("Tid Activity", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i("Tid Activity", "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("Tid Activity", "onDestroy")
        super.onDestroy()
    }
}
