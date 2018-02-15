package ru.mincor.kotlindesignpatterns.patterns.decorator.coffe

import ru.mincor.kotlindesignpatterns.patterns.decorator.base.Beverage

/**
 * Created by a.minkin on 15.02.2018.
 */
class Capuccino(sz:Int = Beverage.NORMALL) : Beverage("Capuccino", sz) {
    override val cost: Float = 2.59f
}