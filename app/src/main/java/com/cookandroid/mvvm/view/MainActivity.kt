package com.cookandroid.mvvm.view

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.cookandroid.mvvm.databinding.ActivityMainBinding
import com.cookandroid.mvvm.viewmodel.OrderViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: OrderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(OrderViewModel::class.java)
        setAppleQtyObserver()
        setTotalPriceObserver()
        setDecreaseButtonClickListener()
        setIncreaseButtonClickListener()
    }

    private fun setAppleQtyObserver(){
        viewModel.appleQuantity.observe(this){
            binding.appleCountText.text = it
        }
    }

    private fun setTotalPriceObserver(){
        viewModel.totalPrice.observe(this){
            binding.totalCountText.text = it
        }
    }

    private fun setIncreaseButtonClickListener(){
        binding.increaseAppleButton.setOnClickListener {
            viewModel.addApple()
        }
    }

    private fun setDecreaseButtonClickListener(){
        binding.decreaseAppleButton.setOnClickListener {
            viewModel.decreaseApple()
        }
    }

}