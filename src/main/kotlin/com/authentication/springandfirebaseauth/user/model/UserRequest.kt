package com.authentication.springandfirebaseauth.user.model

data class UserRequest(
        val email: String,
        val password: String,
        val displayName: String
)
