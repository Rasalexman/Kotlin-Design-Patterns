package ru.mincor.kotlindesignpatterns.patterns.strategy

import android.os.Bundle
import android.view.MenuItem
import ru.mincor.kotlindesignpatterns.activity.BackActivity
import ru.mincor.kotlindesignpatterns.patterns.strategy.behavior.weapon.SwordBehavior

/**
 * Created by a.minkin on 15.02.2018.
 */
class StrategyActivity : BackActivity() {
    /**
     * Паттерн "СТРАТЕГИЯ" - определяет семейство алгоритмов, инкапсулирует и обеспечивает их взаимозаменяемость.
     * Паттерн позволяет модифицировать алгоритмы независимо от их использования на стороне клиента.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "STRATEGY PATTERN EXAMPLE"

        val knight = Knight()
        val thief = Thief()
        val troll = Troll()

        knight.fight()
        troll.defense()

        thief.fight()
        knight.defense()

        troll.fight()
        thief.defense()

        thief.weapon = SwordBehavior()
        thief.fight()
    }
}