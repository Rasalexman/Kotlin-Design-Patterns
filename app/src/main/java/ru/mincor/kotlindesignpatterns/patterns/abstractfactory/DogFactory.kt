package ru.mincor.kotlindesignpatterns.patterns.abstractfactory

/**
 * The abstract factory pattern is used to provide a client with a set of related or dependant objects. The "family" of objects created by the factory are determined at run-time.
 */

interface Dog {
    val voice:String
}
class Pug : Dog {
    override val voice = "PUG MAKE WOOF"
}
class Bullbog : Dog {
    override val voice = "DOG MAKE WOOOOFF-WOOOFFF ARRR"
}

abstract class DogFactory {
    abstract fun makeDog(): Dog
    companion object {
        inline fun <reified T : Dog> createFactory(): DogFactory = when (T::class) {
            Pug::class -> PugFactory()
            Bullbog::class -> BulldogFactory()
            else -> throw IllegalArgumentException()
        }
    }
}

class PugFactory : DogFactory(){
    override fun makeDog(): Dog = Pug()
}
class BulldogFactory : DogFactory(){
    override fun makeDog(): Dog = Bullbog()
}
