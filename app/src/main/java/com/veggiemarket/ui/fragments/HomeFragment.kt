package com.veggiemarket.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.veggiemarket.R
import com.veggiemarket.databinding.HomeFragmentBinding
import com.veggiemarket.domain.models.Category
import com.veggiemarket.ui.adapters.CategoriesAdapter
import com.veggiemarket.ui.viewmodels.HomeViewModel
import com.veggiemarket.ui.viewstate.HomeViewState
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindObservables()
        initView()
    }

    private fun bindObservables() {
        viewModel.viewState.observe(viewLifecycleOwner, ::handleViewstate)
    }

    private fun handleViewstate(homeViewState: HomeViewState?) {
        homeViewState?.let { viewState ->
            when (viewState) {
                is HomeViewState.OnSuccessFetchedInitialData -> handleInitialView(viewState.categories)
            }
        }
    }

    private fun handleInitialView(categories: List<Category>) {
        val adapter = CategoriesAdapter(categories)
        binding.categoriesRecycler.adapter = adapter
    }

    private fun initView() {
        viewModel.initView()
    }
}
