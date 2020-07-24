package com.android.twoactvities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    companion object{
        const val TAG = "SecondActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d(TAG,"OnCreate")
        val intent = getIntent()
        val message = intent.getStringExtra("Message")
        val textView = findViewById<TextView>(R.id.text_message)
        textView.text = message
    }

    fun launchReply(view: View) {
        val editText = findViewById<EditText>(R.id.replyButtoneditText)
        val intent = Intent()
        intent.putExtra("Reply",editText.text.toString())
        setResult(Activity.RESULT_OK,intent)
        Log.d(TAG,"End SecondActivity")
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"OnPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"OnRestart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"OnDestroy")
    }
}