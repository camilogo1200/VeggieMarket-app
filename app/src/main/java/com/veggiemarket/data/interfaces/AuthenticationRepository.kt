package com.veggiemarket.data.interfaces

import com.veggiemarket.ui.models.AuthenticationData

interface AuthenticationRepository {
    fun authenticateUser():Result<AuthenticationData>
}