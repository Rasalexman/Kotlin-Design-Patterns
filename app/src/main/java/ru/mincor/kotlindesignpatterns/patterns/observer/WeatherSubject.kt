package ru.mincor.kotlindesignpatterns.patterns.observer

import ru.mincor.kotlindesignpatterns.patterns.observer.base.Observer
import ru.mincor.kotlindesignpatterns.patterns.observer.base.Subject
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by a.minkin on 15.02.2018.
 */
class WeatherSubject(t:Float, h:Float, p:Float) : Subject {

    var temperature:Float by Delegates.observable(0f, {
        _, _, _ -> notifyObservers()
    })

    var humidity:Float by TemperatureDelegate()

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

    inner class TemperatureDelegate {
        operator fun setValue(thisRef: Any?, property: KProperty<*>, value:Float?){
            notifyObservers()
        }

        operator fun getValue(weatherSubject: WeatherSubject, property: KProperty<*>): Float {
            return weatherSubject.temperature
        }
    }
}