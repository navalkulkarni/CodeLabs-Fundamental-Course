package com.android.implicitintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.core.app.ShareCompat

class MainActivity : AppCompatActivity() {

   private lateinit var mWebsiteEditText : EditText
   private lateinit var mLocationEditText : EditText
   private lateinit var mShareEditText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mWebsiteEditText = findViewById(R.id.website_edittext)
        mLocationEditText = findViewById(R.id.location_edittext)
        mShareEditText = findViewById(R.id.location_edittext)
    }

    fun openWebsite(view: View) {
        val url = mWebsiteEditText.text.toString()
        val uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW,uri)

        if(intent.resolveActivity(packageManager)!= null)
            startActivity(intent)
        else
            Log.d("ImplicitIntents","Can't handle this intent")
    }

    fun openLocation(view: View) {
        val loc = mLocationEditText.text.toString()
        val addressUri = Uri.parse("geo:0,0?q=" + loc)
        val intent = Intent(Intent.ACTION_VIEW,addressUri)

        if(intent.resolveActivity(packageManager)!= null)
            startActivity(intent)
        else
            Log.d("ImplicitIntents","Can't handle this intent")
    }

    fun shareText(view: View) {
        val text = mShareEditText.text.toString()
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle(R.string.share_text_with)
            .setText(text)
            .startChooser()
    }
}