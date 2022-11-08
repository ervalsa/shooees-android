package com.sepatu.shooees.ui.register

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sepatu.shooees.databinding.ActivityRegisterBinding
import com.sepatu.shooees.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playAnimation()

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
}