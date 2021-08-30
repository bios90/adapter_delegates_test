package com.bios.adapterdelegatestest.models.models

import android.util.Log

class Eagle(name: String, weight: Double) : Animal(name, weight) {
    override fun inroduceYourSelf():String {
        return "I am Eagle(!) " + name + " and my weight is " + weight
    }

    override fun makeSound() {
        Log.e("MakingSound", "Karrrrrr")
    }
}
