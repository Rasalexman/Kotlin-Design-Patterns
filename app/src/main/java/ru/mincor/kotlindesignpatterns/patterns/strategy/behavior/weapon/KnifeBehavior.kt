package ru.mincor.kotlindesignpatterns.patterns.strategy.behavior.weapon

import ru.mincor.kotlindesignpatterns.patterns.strategy.behavior.weapon.base.WeaponBehavior

/**
 * Created by a.minkin on 15.02.2018.
 */
class KnifeBehavior : WeaponBehavior {
    override fun useWeapon() {
        println("KNIFE ATTACK")
    }
}