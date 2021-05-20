package com.rivaldofez.moviers.ui.trailer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebViewClient
import com.rivaldofez.moviers.R
import com.rivaldofez.moviers.databinding.ActivityTrailerBinding

class TrailerActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_TRAILER = "extra_trailer"
    }
    private lateinit var trailerBinding: ActivityTrailerBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        trailerBinding = ActivityTrailerBinding.inflate(layoutInflater)
        setContentView(trailerBinding.root)
        setActionBar()

        trailerBinding.webTrailer.settings.javaScriptEnabled = true

        trailerBinding.webTrailer.webViewClient = WebViewClient()

        val bundle = intent.extras
        if(bundle != null){
            val trailerUrl = bundle.getString(EXTRA_TRAILER)
            if(trailerUrl != null)
                trailerBinding.webTrailer.loadUrl(trailerUrl)
        }
    }

    private fun setActionBar(){
        supportActionBar?.title = getString(R.string.trailer)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}