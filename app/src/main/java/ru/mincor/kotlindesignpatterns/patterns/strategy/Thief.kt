package ru.mincor.kotlindesignpatterns.patterns.strategy

import ru.mincor.kotlindesignpatterns.patterns.strategy.behavior.armor.CopperArmorBehaviour
import ru.mincor.kotlindesignpatterns.patterns.strategy.behavior.weapon.KnifeBehavior

/**
 * Created by a.minkin on 15.02.2018.
 */
class Thief : Character(KnifeBehavior(), CopperArmorBehaviour()) {
    override fun fight() {
        println("Thief fight")
        super.fight()
    }

    override fun defense() {
        println("Thief defense")
        super.defense()
    }
}