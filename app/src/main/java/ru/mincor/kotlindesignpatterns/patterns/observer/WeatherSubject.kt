package ru.mincor.kotlindesignpatterns.patterns.observer

import ru.mincor.kotlindesignpatterns.patterns.observer.base.Observer
import ru.mincor.kotlindesignpatterns.patterns.observer.base.Subject

/**
 * Created by a.minkin on 15.02.2018.
 */
class WeatherSubject(t:Float, h:Float, p:Float) : Subject {

    var temperature:Float = t
            set(value){
                field = value
                notifyObservers()
            }

    var humidity:Float = h
        set(value){
            field = value
            notifyObservers()
        }

    var pressure:Float = p
        set(value){
            field = value
            notifyObservers()
        }

    private val observers = arrayListOf<Observer>()

    override fun reigsterObserver(o: Observer) {
        if(observers.indexOf(o) < 0) observers.add(o)
    }

    override fun removeObserver(o: Observer) {
        if(observers.indexOf(o) >= 0){
            observers.remove(o)
        }
    }

    override fun notifyObservers() {
        observers.forEach { it.update(temperature, humidity, pressure) }
    }
}