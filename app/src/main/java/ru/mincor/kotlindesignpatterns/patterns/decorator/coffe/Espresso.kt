package ru.mincor.kotlindesignpatterns.patterns.decorator.coffe

import ru.mincor.kotlindesignpatterns.patterns.decorator.base.Beverage

/**
 * Created by a.minkin on 15.02.2018.
 */
class Espresso : Beverage("Espresso") {
    override val cost: Float = 1.99f
}