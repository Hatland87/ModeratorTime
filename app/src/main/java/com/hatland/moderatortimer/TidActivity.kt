package com.hatland.moderatortimer

import android.graphics.Color
import android.graphics.Color.GREEN
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

        ScreenControll.alwaysOn(window)
        ScreenControll.fullscreen(window)

        val tid = intent.getLongExtra("TID", 0) * 1000

        buttonStoppTid.setBackgroundColor(Color.rgb(101, 207, 110))

        object : CountDownTimer(tid, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                buttonStoppTid.text = (millisUntilFinished / 60000).toString().padStart(2, '0') + ":" + ((millisUntilFinished % 60000) /1000).toString().padStart(2, '0')

                if (millisUntilFinished <= 16000) {
                    buttonStoppTid.setBackgroundColor(Color.YELLOW)
                }
            }

            override fun onFinish() {
                buttonStoppTid.text = "Done!"
                buttonStoppTid.setBackgroundColor(Color.RED)
            }
        }.start()

    }

    fun killCountDown(view: View) {
        finish()
    }
}
