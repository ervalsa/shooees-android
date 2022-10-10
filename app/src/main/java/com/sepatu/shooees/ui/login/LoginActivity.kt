package com.sepatu.shooees.ui.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sepatu.shooees.MainActivity
import com.sepatu.shooees.databinding.ActivityLoginBinding
import com.sepatu.shooees.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playAnimation()


        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


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
}