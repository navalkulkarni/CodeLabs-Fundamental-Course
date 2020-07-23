package com.android.twoactvities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.sendButtoneditText)
    }

    fun launchSecondActivity(view: View) {
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("Message",editText.text.toString())
        startActivity(intent)
    }
}