package ru.mincor.kotlindesignpatterns.patterns.strategy

import ru.mincor.kotlindesignpatterns.patterns.strategy.behavior.armor.GoldArmorBehavior
import ru.mincor.kotlindesignpatterns.patterns.strategy.behavior.weapon.SwordBehavior

/**
 * Created by a.minkin on 15.02.2018.
 */
class Knight : Character(SwordBehavior(), GoldArmorBehavior()) {

    override fun fight() {
        println("Knight fight")
        super.fight()
    }

    override fun defense() {
        println("Knight defense")
        super.defense()
    }
}