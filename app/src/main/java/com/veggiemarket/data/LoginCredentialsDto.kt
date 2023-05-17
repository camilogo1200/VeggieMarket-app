package com.veggiemarket.data

import com.veggiemarket.ui.models.AuthenticationData

data class LoginCredentialsDto(
    val username: String,
    val email: String,
    val authenticationToken: String,
    val refreshToken: String
) {
    fun toModel(): AuthenticationData {
        return AuthenticationData(
            this.username,
            authenticationToken,
            refreshToken
        )
    }
}
