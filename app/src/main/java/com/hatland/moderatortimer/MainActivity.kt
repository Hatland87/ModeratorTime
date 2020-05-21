package com.hatland.moderatortimer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var tidInnleggSekunder = 120
    private var tidReplikkSekunder = 60

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ScreenControll.alwaysOn(window)
        ScreenControll.fullscreen(window)

        updateValuesOnScreen()
    }

    // updates textViews
    private fun updateValuesOnScreen() {
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
            updateValuesOnScreen()
        }
    }

    fun mindreTidInnlegg (view: View) {
        // never below 0 secounds
        if (tidInnleggSekunder > 0) {
            tidInnleggSekunder -= 10
            updateValuesOnScreen()
        }
    }

    fun merTidReplikk (view: View) {
        // never above 60 min
        if (tidReplikkSekunder < 3600) {
            tidReplikkSekunder += 10
            updateValuesOnScreen()
        }
    }

    fun mindreTidReplikk (view: View) {
        // never below 0 secounds
        if (tidReplikkSekunder > 0) {
            tidReplikkSekunder -= 10
            updateValuesOnScreen()
        }
    }
}
