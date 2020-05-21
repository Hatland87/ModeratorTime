package com.hatland.moderatortimer

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalTime
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tidInnleggSekunder = 120
    private var tidReplikkSekunder = 60

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // fullscreen
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN)

        buttonPress()
    }

    // updates textViews
    private fun buttonPress() {
        val iMin = (tidInnleggSekunder / 60).toString().padStart(2, '0')
        val iSek = (tidInnleggSekunder % 60).toString().padStart(2, '0')
        val rMin = (tidReplikkSekunder / 60).toString().padStart(2, '0')
        val rSek = (tidReplikkSekunder % 60).toString().padStart(2, '0')
        textViewTimeInnlegg.text = "${iMin}:${iSek}"
        textViewTimeReplikk.text = "${rMin}:${rSek}"
    }

    fun startNy(view: View) {
        val intent = Intent(this, ControllActivity::class.java).apply {
            putExtra("TID_INNLEGG", tidInnleggSekunder)
            putExtra("TID_REPLIKK", tidReplikkSekunder)
        }
        startActivity(intent)
    }

    fun merTidInnlegg (view: View) {
        // never above 60 min
        if (tidInnleggSekunder < 3600) {
            tidInnleggSekunder += 10
            buttonPress()
        }
    }

    fun mindreTidInnlegg (view: View) {
        // never below 0 secounds
        if (tidInnleggSekunder > 0) {
            tidInnleggSekunder -= 10
            buttonPress()
        }
    }

    fun merTidReplikk (view: View) {
        // never above 60 min
        if (tidReplikkSekunder < 3600) {
            tidReplikkSekunder += 10
            buttonPress()
        }
    }

    fun mindreTidReplikk (view: View) {
        // never below 0 secounds
        if (tidReplikkSekunder > 0) {
            tidReplikkSekunder -= 10
            buttonPress()
        }
    }
}
