package com.sepatu.shooees.ui.register

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.sepatu.shooees.data.source.remote.response.auth.AuthResponse
import com.sepatu.shooees.data.source.remote.retrofit.ApiConfig
import com.sepatu.shooees.databinding.ActivityRegisterBinding
import com.sepatu.shooees.ui.login.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playAnimation()

        binding.btnSignUp.setOnClickListener {
            registerAuth()
        }

        binding.tvSignIn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupRegister() {
        val name = binding.nameEditText.text.toString()
        val username = binding.usernameEditText.text.toString()
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        when {
            name.isEmpty() -> {
                binding.nameEditText.error = "Nama tidak boleh kosong"
            }

            username.isEmpty() -> {
                binding.usernameEditText.error = "Username tidak boleh kosong"
            }

            email.isEmpty() -> {
                binding.emailEditText.error = "Email tidak boleh kosong"
            }

            password.isEmpty() -> {
                binding.passwordEditText.error = "Password tidak boleh kosong"
            }

            else -> {
                registerAuth()
            }
        }
    }

    private fun registerAuth() {
        val name = binding.nameEditText.text.toString()
        val username = binding.usernameEditText.text.toString()
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        showLoading(true)
        val client = ApiConfig
            .getApiService()
            .register(
                name,
                username,
                email,
                password
            )

        client.enqueue(object : Callback<AuthResponse> {
            override fun onResponse(
                call: Call<AuthResponse>,
                response: Response<AuthResponse>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    showLoading(false)
                    AlertDialog.Builder(this@RegisterActivity).apply {
                        setTitle("Selamat!")
                        setMessage("Akun anda sudah jadi. Habiskan uangmu dengan belanja Sepatu")
                        setPositiveButton("Lanjut") { _, _ ->
                            finish()
                        }
                        create()
                        show()
                    }
                } else {
                    showLoading(false)
                    Toast.makeText(this@RegisterActivity, "${response.message()}", Toast.LENGTH_SHORT).show()
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                showLoading(false)
                Log.e(TAG, "onFailure ${t.message}")
            }

        })
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun playAnimation() {
        val titleSignUp = ObjectAnimator.ofFloat(binding.tvSignUp, View.ALPHA, 1f).setDuration(500)
        val descSignUp = ObjectAnimator.ofFloat(binding.tvDescSignUp, View.ALPHA, 1f).setDuration(500)
        val titleName = ObjectAnimator.ofFloat(binding.tvName, View.ALPHA, 1f).setDuration(300)
        val edtName = ObjectAnimator.ofFloat(binding.inputNameLayout, View.ALPHA, 1f).setDuration(300)
        val titleUsername = ObjectAnimator.ofFloat(binding.tvUsername, View.ALPHA, 1f).setDuration(300)
        val edtUsername = ObjectAnimator.ofFloat(binding.inputUsernameLayout, View.ALPHA, 1f).setDuration(300)
        val titleEmail = ObjectAnimator.ofFloat(binding.tvEmail, View.ALPHA, 1f).setDuration(300)
        val edtEmail = ObjectAnimator.ofFloat(binding.inputEmailLayout, View.ALPHA, 1f).setDuration(300)
        val titlePassword = ObjectAnimator.ofFloat(binding.tvPassword, View.ALPHA, 1f).setDuration(300)
        val edtPassword = ObjectAnimator.ofFloat(binding.inputPasswordLayout, View.ALPHA, 1f).setDuration(300)
        val btnSignUp = ObjectAnimator.ofFloat(binding.btnSignUp, View.ALPHA, 1f).setDuration(300)
        val ctaLink = ObjectAnimator.ofFloat(binding.linearLayout, View.ALPHA, 1f).setDuration(300)

        AnimatorSet().apply {
            playSequentially(
                titleSignUp,
                descSignUp,
                titleName,
                edtName,
                titleUsername,
                edtUsername,
                titleEmail,
                edtEmail,
                titlePassword,
                edtPassword,
                btnSignUp,
                ctaLink
            )
            start()
        }
    }

    companion object {
        private val TAG = "RegisterActivity"
    }
}