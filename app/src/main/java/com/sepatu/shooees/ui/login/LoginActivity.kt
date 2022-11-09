package com.sepatu.shooees.ui.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.sepatu.shooees.MainActivity
import com.sepatu.shooees.data.entity.UserEntity
import com.sepatu.shooees.data.source.local.datastore.UserPreference
import com.sepatu.shooees.data.source.remote.response.auth.AuthResponse
import com.sepatu.shooees.data.source.remote.retrofit.ApiConfig
import com.sepatu.shooees.databinding.ActivityLoginBinding
import com.sepatu.shooees.ui.ViewModelFactory
import com.sepatu.shooees.ui.register.RegisterActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        playAnimation()

        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            auth()
        }
    }

    private fun auth() {
        showLoading(true)
        val client = ApiConfig
            .getApiService()
            .login(
                binding.emailEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )

        client.enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    showLoading(false)
                    loginViewModel.saveUser(
                        UserEntity(
                            responseBody.data.user.name,
                            responseBody.data.user.email,
                            responseBody.data.user.username,
                            responseBody.data.user.phone,
                            responseBody.data.accessToken,
                            isLogin = true
                        )
                    )

                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Log.e(TAG, "onFailure ${response.message()}")
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.e(TAG, "onFailure ${t.message}")
            }

        })
    }

    private fun showLoading(isLoading: Boolean) {
        if  (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun setupViewModel() {
        loginViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                UserPreference
                    .getInstance(dataStore)
            )
        )[LoginViewModel::class.java]
    }

    private fun playAnimation() {
        val titleSignIn = ObjectAnimator.ofFloat(binding.tvSignIn, View.ALPHA, 1f).setDuration(500)
        val descSignIn = ObjectAnimator.ofFloat(binding.tvDescSignIn, View.ALPHA, 1f).setDuration(500)
        val titleEmail = ObjectAnimator.ofFloat(binding.tvEmailAddress, View.ALPHA, 1f).setDuration(300)
        val edtEmail = ObjectAnimator.ofFloat(binding.inputEmailLayout, View.ALPHA, 1f).setDuration(300)
        val titlePassword = ObjectAnimator.ofFloat(binding.tvPassword, View.ALPHA, 1f).setDuration(300)
        val edtPassword = ObjectAnimator.ofFloat(binding.inputPasswordLayout, View.ALPHA, 1f).setDuration(300)
        val btnLogin = ObjectAnimator.ofFloat(binding.btnLogin, View.ALPHA, 1f).setDuration(300)
        val ctaLink = ObjectAnimator.ofFloat(binding.linearLayout, View.ALPHA, 1f).setDuration(300)

        AnimatorSet().apply {
            playSequentially(
                titleSignIn,
                descSignIn,
                titleEmail,
                edtEmail,
                titlePassword,
                edtPassword,
                btnLogin,
                ctaLink
            )
            start()
        }
    }

    companion object {
        private val TAG = "LoginActivity"
    }
}