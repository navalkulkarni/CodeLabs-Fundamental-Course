package com.android.twoactvities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val intent = getIntent()
        val message = intent.getStringExtra("Message")
        val textView = findViewById<TextView>(R.id.text_message)
        textView.text = message
    }

    fun launchReply(view: View) {

    }
}