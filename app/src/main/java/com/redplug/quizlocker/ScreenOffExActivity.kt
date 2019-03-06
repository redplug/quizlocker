package com.redplug.quizlocker

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ScreenOffExActivity : AppCompatActivity() {

    // ScreenOffReceiver 객체
    var screenOffReceiver: ScreenOffReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_off_ex)

        // screenOffReceiver 가 널인 경우에만 screenOffreceiver 를 생성하고 등록한다.
        if (screenOffReceiver == null ) {
            screenOffReceiver = ScreenOffReceiver()
            val intentFilter = IntentFilter(Intent.ACTION_SCREEN_OFF)
            registerReceiver(screenOffReceiver, intentFilter)
        }
    }
}
