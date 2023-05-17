package com.veggiemarket.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.veggiemarket.R
import com.veggiemarket.databinding.LoginFragmentBinding
import com.veggiemarket.ui.viewstate.LoginViewState
import com.veggiemarket.ui.viewstate.LoginViewState.OnSuccessLogin
import com.veggiemarket.ui.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    lateinit var binding: LoginFragmentBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindListeners()
        bindObservables()
    }

    private fun bindObservables() {
        viewModel.viewState.observe(viewLifecycleOwner, ::handleViewState)
    }

    private fun handleViewState(loginViewState: LoginViewState?) {
        loginViewState?.let { state ->
            when (state) {
                is OnSuccessLogin -> navigateToHome(state)
                else -> {
                    showError()
                }
            }
        }
    }

    private fun showError() {

        findNavController().navigate(R.id.action_loginFragment_to_errorFragment)
        Toast.makeText(requireContext(), "Authentication Failed.", Toast.LENGTH_LONG).show()
    }

    private fun navigateToHome(state: OnSuccessLogin) {
        val navController = findNavController()
        navController.navigate(R.id.action_loginFragment_to_homeFragment)
    }

    private fun bindListeners() {
        binding.nextBtn.setOnClickListener {

            val email = binding.emailAddress.text.toString();
            val password = binding.password.text.toString()
            viewModel.validateLoginData(email, password)
        }

        binding.signUp.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_loginFragment_to_registerAccountFragment)
        }
    }

}