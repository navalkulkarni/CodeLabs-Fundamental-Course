package com.android.hellocompat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var colorButton: Button
    private val colors = arrayOf("red", "pink", "purple", "deep_purple",
        "indigo", "blue", "light_blue", "cyan", "teal", "green",
        "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
        "brown", "grey", "blue_grey")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.helloTextView)
        colorButton = findViewById(R.id.changeColorButton)

        if(savedInstanceState!=null)
            textView.setTextColor(savedInstanceState.getInt("color"))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("color",textView.currentTextColor)
    }

    fun changeColor(view: View) {

        val colorName = colors[Random.nextInt(0,18)]
        val colorResourceName = getResources().getIdentifier(colorName,
            "color", getApplicationContext().getPackageName())
        val colorRes = ContextCompat.getColor(this,colorResourceName)
        textView.setTextColor(colorRes)
    }
}