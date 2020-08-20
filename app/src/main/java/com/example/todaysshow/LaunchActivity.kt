package com.example.todaysshow

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.widget.Toast

class LaunchActivity : Activity() {
    var handler : Handler = Handler()
    var runnable: Runnable = Runnable(){
        kotlin.run {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        handler.postDelayed(runnable, 1500)

    }
}
