package com.sepatu.shooees.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.sepatu.shooees.MainActivity
import com.sepatu.shooees.R
import com.sepatu.shooees.databinding.ActivitySplashBinding
import com.sepatu.shooees.ui.login.LoginActivity

class SplashScreenActivity : AppCompatActivity() {

    companion object {
        const val timer = 2000
    }

    lateinit var handler: Handler

    private lateinit var splashScreenBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreenBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashScreenBinding.root)

        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, timer.toLong())
    }
}