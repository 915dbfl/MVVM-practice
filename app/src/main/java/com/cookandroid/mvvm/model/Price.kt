package com.cookandroid.mvvm.model

class Price {
    var totalPrice = 0

    fun increaseTotalPrice(price: Int) {
        totalPrice += price
    }

    fun decreaseTotalPrice(price: Int){
        totalPrice -= price
        if (totalPrice < 0){
            totalPrice = 0
        }
    }
}