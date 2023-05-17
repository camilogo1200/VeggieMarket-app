package com.veggiemarket.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.veggiemarket.data.interfaces.ProductsRepository
import com.veggiemarket.ui.viewstate.HomeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val productsRepository: ProductsRepository
) : ViewModel() {
    private val _viewState = MutableLiveData<HomeViewState>()
    val viewState: LiveData<HomeViewState> = _viewState


    fun setViewState(state: HomeViewState) {
        _viewState.value = state
    }

    fun initView() {
        kotlin.runCatching {
            val result = productsRepository.getCategories()
            result.getOrThrow()
        }.onSuccess { categories ->
            setViewState(HomeViewState.OnSuccessFetchedInitialData(categories))
        }.onFailure {

        }
    }

}
