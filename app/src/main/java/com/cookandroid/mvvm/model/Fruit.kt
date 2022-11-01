package com.cookandroid.mvvm.model

open class Fruit(price: Int) {
    var price = price
    var quantity = 0

    open fun add() {}
    open fun decrease() {}
}