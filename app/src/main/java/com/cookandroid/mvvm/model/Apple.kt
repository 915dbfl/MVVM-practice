package com.cookandroid.mvvm.model

class Apple : Fruit(700){
    override fun add() {
        ++quantity
    }

    override fun decrease() {
        --quantity
        if (quantity < 0){
            quantity = 0
        }
    }
}