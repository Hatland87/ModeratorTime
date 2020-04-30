package com.hatland.moderatortimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_controll.*
import java.util.logging.Logger

class ControllActivity : AppCompatActivity() {

    private var tidInnleggSekunder = 0
    private var tidReplikkSekunder = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("Controll Activity", "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_controll)

        tidInnleggSekunder = intent.getIntExtra("TID_INNLEGG", 0)
        tidReplikkSekunder = intent.getIntExtra("TID_REPLIKK", 0)

    }

    fun startTid(view: View) {

    }

    override fun onStart() {
        Log.i("Controll Activity", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i("Controll Activity", "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i("Controll Activity", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i("Controll Activity", "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("Controll Activity", "onDestroy")
        super.onDestroy()
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
