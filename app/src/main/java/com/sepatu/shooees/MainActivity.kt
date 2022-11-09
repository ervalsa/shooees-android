package com.sepatu.shooees

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.sepatu.shooees.data.source.local.datastore.UserPreference
import com.sepatu.shooees.databinding.ActivityMainBinding
import com.sepatu.shooees.ui.ViewModelFactory
import com.sepatu.shooees.ui.login.LoginActivity
import com.sepatu.shooees.ui.main.MainViewModel
import com.sepatu.shooees.ui.main.home.HomeFragment

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        setupViewModel()

        val navController = findNavController(R.id.nav_host_fragment)
        mainBinding.navView.setupWithNavController(navController)
        mainBinding.navView.itemIconTintList = null
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                UserPreference
                    .getInstance(dataStore)
            )
        )[MainViewModel::class.java]
    }
}