package ru.mincor.kotlindesignpatterns.patterns.observer.base

/**
 * Created by a.minkin on 15.02.2018.
 */
interface Observer {
    fun update(temperature:Float, humidity:Float, pressure:Float)
}