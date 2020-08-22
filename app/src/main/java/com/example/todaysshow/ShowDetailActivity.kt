package com.example.todaysshow

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kr.co.prnd.YouTubePlayerView


class ShowDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)

        var showDetailCloseButton : Button = findViewById<Button>(R.id.show_detail_close_bt)
        showDetailCloseButton.setOnClickListener(View.OnClickListener {
            finish()
        })

        var youTubePlayer = findViewById<YouTubePlayerView>(R.id.show_detail_youtube)

        youTubePlayer.play(VIDEO_ID)

    }

    companion object{
        private const val VIDEO_ID = "a7AP-XrBKC0"
    }


}