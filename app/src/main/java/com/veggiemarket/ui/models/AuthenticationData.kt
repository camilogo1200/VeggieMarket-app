package com.veggiemarket.ui.models

data class AuthenticationData(
    val name: String,
    val authenticationToken: String,
    val refreshToken: String
)