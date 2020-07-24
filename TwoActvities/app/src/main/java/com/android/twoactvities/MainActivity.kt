package com.android.twoactvities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object{
        const val REQUEST_CODE = 123
        const val TAG = "MainActivity"
    }


    lateinit var editText: EditText
    lateinit var replyHeader: TextView
    lateinit var replyText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"OnCreate")
        editText = findViewById(R.id.sendButtoneditText)
        replyHeader = findViewById(R.id.text_reply_header)
        replyText = findViewById(R.id.text_reply_message)
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