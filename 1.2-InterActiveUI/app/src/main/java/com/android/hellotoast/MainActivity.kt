package com.android.hellotoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var count = 0;
    lateinit var countTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countTextView = findViewById(R.id.show_count)
    }

    fun countUp(view: View) {
        count++
        if(count!=null)
            countTextView.text = count.toString()
    }
    fun showToast(view: View) {

        Toast.makeText(this,"Hello Toast",Toast.LENGTH_SHORT).show()

    }
}