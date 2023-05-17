package com.veggiemarket.data

import com.veggiemarket.data.interfaces.ProductsRepository
import com.veggiemarket.domain.models.Category
import com.veggiemarket.domain.models.Product
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor() : ProductsRepository {
    override fun getCategories(): Result<List<Category>> {
        val lCategories = listOf(
            Category(
                name = "Vegetables",
                description = "",
            ),
            Category(
                name = "Fruits",
                description = ""
            ),
            Category(
                name = "Meats",
                description = ""
            ),
            Category(
                name = "Fish",
                description = ""
            ),
            Category(
                name = "Milk",
                description = ""
            ),
            Category(
                name = "Eggs",
                description = ""
            ),
            Category(
                name = "Vegetables",
                description = ""
            ),
        )

        return Result.success(lCategories)
    }
}