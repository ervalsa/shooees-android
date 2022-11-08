package com.sepatu.shooees.data.entity

data class UserEntity(
    val name: String,
    val email: String,
    val username: String,
    val phone: String,
    val token: String,
    val isLogin: Boolean
)
