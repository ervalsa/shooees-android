package com.sepatu.shooees.data.source.remote.response.auth

import com.google.gson.annotations.SerializedName

data class User(

    @field:SerializedName("profile_photo_url")
    val profilePhotoUrl: String,

    @field:SerializedName("roles")
    val roles: String,

    @field:SerializedName("created_at")
    val createdAt: String,

    @field:SerializedName("email_verified_at")
    val emailVerifiedAt: Any,

    @field:SerializedName("current_team_id")
    val currentTeamId: Any,

    @field:SerializedName("updated_at")
    val updatedAt: String,

    @field:SerializedName("phone")
    val phone: String? = null,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("profile_photo_path")
    val profilePhotoPath: Any,

    @field:SerializedName("two_factor_confirmed_at")
    val twoFactorConfirmedAt: Any,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("username")
    val username: String
)
