package com.veggiemarket.data.interfaces

import com.veggiemarket.domain.models.Category
import com.veggiemarket.domain.models.Product

interface ProductsRepository {
    fun getCategories(): Result<List<Category>>
}