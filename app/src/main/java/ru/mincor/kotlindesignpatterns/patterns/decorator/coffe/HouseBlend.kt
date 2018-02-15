package ru.mincor.kotlindesignpatterns.patterns.decorator.coffe

import ru.mincor.kotlindesignpatterns.patterns.decorator.base.Beverage

/**
 * Created by a.minkin on 15.02.2018.
 */
class HouseBlend : Beverage("House Blend Coffee") {
    override val cost: Float = 0.89f
}