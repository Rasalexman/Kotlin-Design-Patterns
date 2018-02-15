package ru.mincor.kotlindesignpatterns.patterns.strategy.behavior.armor

import ru.mincor.kotlindesignpatterns.patterns.strategy.behavior.armor.base.ArmorBehavior

/**
 * Created by a.minkin on 15.02.2018.
 */
class IronArmorBehavior : ArmorBehavior {
    override fun useArmor() {
        println("IronArmor DEFENSE")
    }
}