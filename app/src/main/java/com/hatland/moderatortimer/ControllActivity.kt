package com.hatland.moderatortimer

import android.content.Intent
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
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_controll)

        // fullscreen
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN)

        tidInnleggSekunder = intent.getIntExtra("TID_INNLEGG", 0)
        tidReplikkSekunder = intent.getIntExtra("TID_REPLIKK", 0)

    }

    fun startInnlegg(view: View) {
        startNewActivity(tidInnleggSekunder)
    }

    fun startReplikk(view: View) {
        startNewActivity(tidReplikkSekunder)
    }

    private fun startNewActivity(tid: Int) {
        startActivity(Intent(this, TidActivity::class.java).apply {
            putExtra("TID", tid.toLong())
        })
    }
}
