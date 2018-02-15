package ru.mincor.kotlindesignpatterns.patterns.strategy.behavior.armor

import ru.mincor.kotlindesignpatterns.patterns.strategy.behavior.armor.base.ArmorBehavior

/**
 * Created by a.minkin on 15.02.2018.
 */
class CopperArmorBehaviour : ArmorBehavior {
    override fun useArmor() {
        println("CopperArmor DEFENSE")
    }
}