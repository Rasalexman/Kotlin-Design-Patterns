package ru.mincor.kotlindesignpatterns.patterns.decorator

import android.os.Bundle
import ru.mincor.kotlindesignpatterns.activity.BackActivity
import ru.mincor.kotlindesignpatterns.patterns.decorator.base.Beverage
import ru.mincor.kotlindesignpatterns.patterns.decorator.coffe.Capuccino
import ru.mincor.kotlindesignpatterns.patterns.decorator.coffe.Espresso
import ru.mincor.kotlindesignpatterns.patterns.decorator.coffe.HouseBlend
import ru.mincor.kotlindesignpatterns.patterns.decorator.coffe.condiment.Mocha
import ru.mincor.kotlindesignpatterns.patterns.decorator.coffe.condiment.Soy
import ru.mincor.kotlindesignpatterns.patterns.decorator.coffe.condiment.Whip

/**
 * Created by a.minkin on 15.02.2018.
 */
class DecoratorActivity : BackActivity() {
    /**
     * Паттерн ДЕКОРАТОР динамически наделяет объект новыми возможностями
     * и является гибкой альтернативой субклассированию в облати расширения функциональности
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "DECORATOR PATTERN EXAMPLE"

        val beverage:Beverage = Espresso()
        println("FRESH COFFEE #1 ${beverage.description} $${beverage.cost}")

        var beverage2:Beverage = HouseBlend()
        beverage2.size = Beverage.SMALL
        beverage2 = Mocha(beverage2)
        beverage2 = Soy(beverage2)
        beverage2 = Whip(beverage2)

        println("FRESH COFFEE #2 ${beverage2.description} $${beverage2.cost}")

        var beverage3:Beverage = Capuccino(Beverage.BIG)
        beverage3 = Mocha(beverage3)
        beverage3 = Mocha(beverage3)
        beverage3 = Whip(beverage3)

        println("FRESH COFFEE #3 ${beverage3.description} $${beverage3.cost}")
    }
}