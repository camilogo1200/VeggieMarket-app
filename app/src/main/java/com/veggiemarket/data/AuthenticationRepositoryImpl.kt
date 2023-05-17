package com.veggiemarket.data

import com.veggiemarket.data.interfaces.AuthenticationRepository
import com.veggiemarket.ui.models.AuthenticationData
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor() : AuthenticationRepository {
    override fun authenticateUser(): Result<AuthenticationData> {
        return Result.success(
            LoginCredentialsDto(
                "camilogo1200",
                "camilogo1200@gmail.com",
                "8b2df899-4141-4ba9-8204-ff68b2508521",
                "52fa80662e64c128f8389c9ea6c73d4c02368004bf4463491900d11aaadca39d47de1b01361f207c512cfa79f0f92c3395c67ff7928e3f5ce3e3c852b392f976"
            ).toModel()
        )
    }
}