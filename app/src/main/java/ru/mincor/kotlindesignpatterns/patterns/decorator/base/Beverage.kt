package ru.mincor.kotlindesignpatterns.patterns.decorator.base

/**
 * Created by a.minkin on 15.02.2018.
 */
abstract class Beverage(open val description:String = "Unknown Beverage", open var size:Int = NORMALL) {

    companion object {
        const val SMALL = 1
        const val NORMALL = 2
        const val BIG = 3
    }

    abstract val cost:Float
}