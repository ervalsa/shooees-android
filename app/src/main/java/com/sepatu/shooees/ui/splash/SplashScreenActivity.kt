package com.sepatu.shooees.ui.splash

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.sepatu.shooees.MainActivity
import com.sepatu.shooees.R
import com.sepatu.shooees.data.source.local.datastore.UserPreference
import com.sepatu.shooees.databinding.ActivitySplashBinding
import com.sepatu.shooees.ui.ViewModelFactory
import com.sepatu.shooees.ui.login.LoginActivity
import com.sepatu.shooees.ui.login.LoginViewModel
import com.sepatu.shooees.ui.main.MainViewModel

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SplashScreenActivity : AppCompatActivity() {

    companion object {
        const val timer = 2000
    }

    lateinit var handler: Handler

    private lateinit var splashScreenBinding: ActivitySplashBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreenBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashScreenBinding.root)

        handler = Handler()
        handler.postDelayed({
            setupViewModel()
        }, timer.toLong())
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                UserPreference
                    .getInstance(dataStore))
        )[MainViewModel::class.java]

        loginCheck()
    }

    private fun loginCheck() {
        mainViewModel.getUser().observe(this) { user ->
            if (user.isLogin) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}