package ru.mincor.kotlindesignpatterns.patterns.decorator.coffe.condiment

import ru.mincor.kotlindesignpatterns.patterns.decorator.base.Beverage
import ru.mincor.kotlindesignpatterns.patterns.decorator.base.CondimentDecorator

/**
 * Created by a.minkin on 15.02.2018.
 */
class Mocha(bev: Beverage) : CondimentDecorator(bev, "Mocha") {
    override val cost: Float get() {
        val addCost = when(size) {
            Beverage.SMALL -> 0.12f
            Beverage.NORMALL -> 0.25f
            Beverage.BIG -> 0.33f
            else -> 0.25f
        }
        return beverage.cost + addCost
    }
}