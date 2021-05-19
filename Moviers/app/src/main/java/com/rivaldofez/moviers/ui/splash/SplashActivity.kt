package com.rivaldofez.moviers.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.bumptech.glide.Glide
import com.rivaldofez.moviers.R
import com.rivaldofez.moviers.databinding.ActivitySplashBinding
import com.rivaldofez.moviers.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    companion object {
        private const val SPLASH_TIME : Long = 3000
    }

    private lateinit var splashBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)

        Glide.with(this).load(R.drawable.logo_moviers).into(splashBinding.imgLogoSplash)
        splashBinding.progressSplash.visibility = View.VISIBLE

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
            splashBinding.progressSplash.visibility = View.INVISIBLE
        }, SPLASH_TIME)
    }
}