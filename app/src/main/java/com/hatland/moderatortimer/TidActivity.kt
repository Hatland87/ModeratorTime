package com.hatland.moderatortimer

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tid.*


class TidActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tid)

        // fullscreen
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN)

        val tid = intent.getLongExtra("TID", 0) * 1000

        Log.i("Tid Activity", "Tid er $tid")

        object : CountDownTimer(tid, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                textViewTid.text = "seconds remaining: " + millisUntilFinished / 1000
            }

            override fun onFinish() {
                textViewTid.text = "done!"
            }
        }.start()

    }

    fun killCountDown(view: View) {
        finish()
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
