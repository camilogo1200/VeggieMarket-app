package com.veggiemarket.ui.viewstate

import com.veggiemarket.ui.models.AuthenticationData


sealed interface LoginViewState {
    data class OnSuccessLogin(val data: AuthenticationData) : LoginViewState
    object OnFailedLogin : LoginViewState
}