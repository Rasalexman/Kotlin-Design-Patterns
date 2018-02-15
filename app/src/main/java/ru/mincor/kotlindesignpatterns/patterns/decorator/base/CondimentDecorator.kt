package ru.mincor.kotlindesignpatterns.patterns.decorator.base

/**
 * Created by a.minkin on 15.02.2018.
 */
abstract class CondimentDecorator(val beverage: Beverage, desc:String) : Beverage(desc) {
    override var size: Int = beverage.size
    override val description: String = "${beverage.description}, $desc"
}