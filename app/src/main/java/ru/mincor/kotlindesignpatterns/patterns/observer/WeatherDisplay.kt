package ru.mincor.kotlindesignpatterns.patterns.observer

import android.annotation.SuppressLint
import ru.mincor.kotlindesignpatterns.patterns.observer.base.DisplayElement
import ru.mincor.kotlindesignpatterns.patterns.observer.base.Observer
import ru.mincor.kotlindesignpatterns.patterns.observer.base.Subject

/**
 * Created by a.minkin on 15.02.2018.
 */
class WeatherDisplay(subject:Subject) : Observer, DisplayElement {

    private var temp:Float = 0f
    private var hum:Float = 0f
    private var pres:Float = 0f

    init {
        subject.reigsterObserver(this)
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        temp = temperature
        hum = humidity
        pres = pressure
        display()
    }

    @SuppressLint("SetTextI18n")
    override fun display() {
        println("TEMPERATURE = ${temp}C degrees and HUMIDITY = $hum% and PRESSURE = ${pres}rs")
    }
}