package com.android.androidarchapp.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.android.androidarchapp.core.Resource
import com.android.androidarchapp.databinding.ActivityMainBinding
import com.android.androidarchapp.util.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindObservers()
        viewModel.getAllProductList()
    }

    private fun bindObservers() {
        viewModel.result.observe(this) {
            binding.progressBar.visibility = View.GONE
            when (it) {
                is Resource.Success -> {
                    showToast(it.data?.products.toString())
                }

                is Resource.Error -> {
                    showToast("${it.errorResponse?.code} ${it.errorResponse?.message}")
                }

                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                else -> {}
            }
        }
    }
}