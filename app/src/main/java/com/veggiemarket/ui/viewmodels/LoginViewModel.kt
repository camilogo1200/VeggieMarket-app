package com.veggiemarket.ui.viewmodels

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.veggiemarket.data.interfaces.AuthenticationRepository
import com.veggiemarket.ui.viewstate.LoginViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val loginRepository: AuthenticationRepository
) : ViewModel() {

    private val _viewState = MutableLiveData<LoginViewState>()
    val viewState: LiveData<LoginViewState> = _viewState


    fun setViewState(state: LoginViewState) {
        _viewState.value = state
    }

    fun validateLoginData(email: String, password: String) {

        if (isValidEmail(email) && password.isNotBlank() && password.length > 6) {
            kotlin.runCatching {
                val result = loginRepository.authenticateUser()
                result.getOrThrow()
            }.onSuccess { credentials ->
                setViewState(LoginViewState.OnSuccessLogin(credentials))
            }.onFailure {
                setViewState(LoginViewState.OnFailedLogin)
            }
        }else{
            setViewState(LoginViewState.OnFailedLogin)
        }

    }


    private fun isValidEmail(email: String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }
}