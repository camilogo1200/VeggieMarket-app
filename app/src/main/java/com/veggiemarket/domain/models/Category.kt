package com.veggiemarket.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val id: Int = 0,
    val name: String,
    val description: String = ""
)
