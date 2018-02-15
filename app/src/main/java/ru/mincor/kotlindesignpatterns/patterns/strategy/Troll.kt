package ru.mincor.kotlindesignpatterns.patterns.strategy

import ru.mincor.kotlindesignpatterns.patterns.strategy.behavior.armor.IronArmorBehavior
import ru.mincor.kotlindesignpatterns.patterns.strategy.behavior.weapon.AxeBehavior

/**
 * Created by a.minkin on 15.02.2018.
 */
class Troll : Character(AxeBehavior(), IronArmorBehavior()) {
    override fun fight() {
        println("Troll fight")
        super.fight()
    }

    override fun defense() {
        println("Troll defense")
        super.defense()
    }
}