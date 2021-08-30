package com.bios.adapterdelegatestest.models.models

import android.util.Log

class Cat(name: String, weight: Double) : Animal(name, weight) {
    override fun inroduceYourSelf(): String {
        return "I am cat " + name + " and my weight is " + weight
    }

    override fun makeSound() {
        Log.e("MakingSound", "Meowwww")
    }
}