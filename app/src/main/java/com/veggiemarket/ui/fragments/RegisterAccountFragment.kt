package com.veggiemarket.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.veggiemarket.R
import com.veggiemarket.databinding.RegisterAccountFragmentBinding

class RegisterAccountFragment : Fragment() {

    private lateinit var binding : RegisterAccountFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.register_account_fragment, container, false )
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.signInBtn.setOnClickListener {
            navigateToLogin()
        }
        binding.signUpBtn.setOnClickListener {
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        val navController = findNavController()
        navController.navigate(R.id.action_registerAccountFragment_to_loginFragment)
    }
}