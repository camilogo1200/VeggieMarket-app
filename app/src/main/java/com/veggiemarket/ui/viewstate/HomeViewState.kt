package com.veggiemarket.ui.viewstate

import com.veggiemarket.domain.models.Category
import com.veggiemarket.domain.models.Product

sealed interface HomeViewState {

    data class OnSuccessFetchedInitialData(
        val categories : List<Category>
    ):HomeViewState

}