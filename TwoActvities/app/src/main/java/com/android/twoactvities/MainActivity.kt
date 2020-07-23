package com.android.twoactvities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE = 123
    lateinit var editText: EditText
    lateinit var replyHeader: TextView
    lateinit var replyText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.sendButtoneditText)
        replyHeader = findViewById(R.id.text_reply_header)
        replyText = findViewById(R.id.text_reply_message)
    }

    fun launchSecondActivity(view: View) {
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("Message",editText.text.toString())
        startActivityForResult(intent,REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE)
            if(resultCode == Activity.RESULT_OK){
                val message = data?.getStringExtra("Reply")
                replyText.text = message
                replyHeader.visibility = View.VISIBLE
                replyText.visibility = View.VISIBLE
            }
    }
}