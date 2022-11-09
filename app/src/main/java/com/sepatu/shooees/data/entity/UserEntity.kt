package com.sepatu.shooees.data.entity

data class UserEntity(
    val name: String,
    val email: String,
    val username: String,
    val phone: String? = null,
    val token: String,
    val isLogin: Boolean
)
