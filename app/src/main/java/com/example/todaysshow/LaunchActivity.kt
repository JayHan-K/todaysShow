package com.example.todaysshow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        SystemClock.sleep(1300)
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

    }
}
