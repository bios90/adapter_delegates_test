package com.bios.adapterdelegatestest.models.models

import com.bios.adapterdelegatestest.models.TypeAnimal
import io.github.serpro69.kfaker.Faker
import kotlin.random.Random

abstract class Animal(
    val name: String,
    val weight: Double
) {
    abstract fun inroduceYourSelf(): String
    abstract fun makeSound()

    companion object {
        fun getRandomData(): List<Animal> {
            val faker = Faker()
            val animals: MutableList<Animal> = arrayListOf()
            val count = (30..100).random()
            for (i in 0..count) {
                val type = TypeAnimal.values().random()
                if (type == TypeAnimal.CAT) {
                    val weight = Random.nextDouble(1.0, 5.0)
                    val cat = Cat(faker.cat.name(), weight)
                    animals.add(cat)
                } else if (type == TypeAnimal.HUMSTER) {
                    val weight = Random.nextDouble(0.5, 1.0)
                    val humster = Humster(faker.cat.name(), weight)
                    animals.add(humster)
                } else if (type == TypeAnimal.EAGLE) {
                    val weight = Random.nextDouble(1.5, 2.5)
                    val eagle = Eagle(faker.cat.name(), weight)
                    animals.add(eagle)
                } else if (type == TypeAnimal.DOG) {
                    val weight = Random.nextDouble(2.0, 10.0)
                    val dog = Dog(faker.cat.name(), weight)
                    animals.add(dog)
                }
            }

            return animals
        }
    }
}