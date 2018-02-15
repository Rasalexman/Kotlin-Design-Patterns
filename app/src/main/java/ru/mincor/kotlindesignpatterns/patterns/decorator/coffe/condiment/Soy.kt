package ru.mincor.kotlindesignpatterns.patterns.decorator.coffe.condiment

import ru.mincor.kotlindesignpatterns.patterns.decorator.base.Beverage
import ru.mincor.kotlindesignpatterns.patterns.decorator.base.CondimentDecorator

/**
 * Created by a.minkin on 15.02.2018.
 */
class Soy(bev: Beverage) : CondimentDecorator(bev, "Soy") {
    override val cost: Float = 0.40f + beverage.cost
}