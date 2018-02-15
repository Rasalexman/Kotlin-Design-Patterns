package ru.mincor.kotlindesignpatterns.patterns.observer.base

/**
 * Created by a.minkin on 15.02.2018.
 */
interface Subject {
    fun reigsterObserver(o:Observer)
    fun removeObserver(o:Observer)
    fun notifyObservers()
}