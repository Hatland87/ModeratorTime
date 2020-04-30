package com.hatland.moderatortimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var tidInnlegg = 0
    private var tidReplikk = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPress()
    }

    private fun buttonPress() {
        textViewTimeInnlegg.text = tidInnlegg.toString()
        textViewTimeReplikk.text = tidReplikk.toString()
    }

    fun merTidInnlegg (view: View) {
        tidInnlegg++
        buttonPress()
    }

    fun mindreTidInnlegg (view: View) {
        tidInnlegg--
        buttonPress()
    }

    fun merTidReplikk (view: View) {
        tidReplikk++
        buttonPress()
    }

    fun mindreTidReplikk (view: View) {
        tidReplikk--
        buttonPress()
    }

    // fullscreen
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_FULLSCREEN)
        }
    }
}
