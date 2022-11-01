package com.cookandroid.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cookandroid.mvvm.model.Apple
import com.cookandroid.mvvm.model.Fruit
import com.cookandroid.mvvm.model.Price

class OrderViewModel : ViewModel(){
    val appleQuantity: MutableLiveData<String> = MutableLiveData("0")
    val totalPrice: MutableLiveData<String> = MutableLiveData("0")
    private val fruitModel: Fruit = Apple()
    private var priceModel: Price = Price()

    fun decreaseApple(){
        fruitModel.decrease()
        appleQuantity.value = fruitModel.quantity.toString()
        updatePriceDecrease(fruitModel.price)
    }

    fun addApple(){
        fruitModel.add()
        appleQuantity.value = fruitModel.quantity.toString()
        updatePriceIncrease(fruitModel.price)
    }

    private fun updatePriceIncrease(price: Int){
        priceModel.increaseTotalPrice(price)
        totalPrice.value = priceModel.totalPrice.toString()
    }

    private fun updatePriceDecrease(price: Int){
        priceModel.decreaseTotalPrice(price)
        totalPrice.value = priceModel.totalPrice.toString()
    }
}