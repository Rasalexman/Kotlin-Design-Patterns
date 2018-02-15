package ru.mincor.kotlindesignpatterns.patterns.observer

import android.os.Bundle
import ru.mincor.kotlindesignpatterns.activity.BackActivity

/**
 * Created by a.minkin on 15.02.2018.
 */
class ObserverActivity : BackActivity() {
    /**
     * паттерн "НАБЛЮДАТЕЛЬ" - определяет отношение "один-ко-многим" между объектами таким образом,
     * что при измененнии состояния одного объекта происходит автоматическое оповещение и обновление всех зависимых объектов
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "OBSERVER PATTERN EXAMPLE"

        val weatherData = WeatherSubject(14.2f, 65.8f, 736.3f)
        val weatherDisplay = WeatherDisplay(weatherData)
        weatherData.notifyObservers()

        weatherData.temperature = 18.2f
        weatherData.pressure = 752.5f
        weatherData.humidity = 85.1f
    }
}