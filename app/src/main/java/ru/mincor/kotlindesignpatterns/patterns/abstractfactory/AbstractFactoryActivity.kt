package ru.mincor.kotlindesignpatterns.patterns.abstractfactory

import android.os.Bundle
import ru.mincor.kotlindesignpatterns.activity.BackActivity

class AbstractFactoryActivity : BackActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "ABSTRACT FACTORY"

        val dogFactory = DogFactory.createFactory<Pug>()
        val dog = dogFactory.makeDog()
        println("dog $dog make voice ${dog.voice}")
    }
}