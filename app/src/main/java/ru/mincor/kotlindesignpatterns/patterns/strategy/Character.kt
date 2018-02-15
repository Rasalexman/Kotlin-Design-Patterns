package ru.mincor.kotlindesignpatterns.patterns.strategy

import ru.mincor.kotlindesignpatterns.patterns.strategy.behavior.armor.base.ArmorBehavior
import ru.mincor.kotlindesignpatterns.patterns.strategy.behavior.weapon.base.WeaponBehavior

/**
 * Created by a.minkin on 15.02.2018.
 */
abstract class Character(var weapon: WeaponBehavior, var armor:ArmorBehavior) {
    open fun fight() {
        weapon.useWeapon()
    }
    open fun defense() {
        armor.useArmor()
    }
}