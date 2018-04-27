package ru.mincor.kotlindesignpatterns.patterns.Builder

import android.os.Bundle
import ru.mincor.kotlindesignpatterns.activity.BackActivity

class BuilderActivity : BackActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "BUILDER PATTERN EXAMPLE"

        Person.create {
            name { "Alexander" }
            surname { "Minkin" }
            age { 28 }
        }

        // OR

        Person.create {
            name = "Alexander"
            surname = "Minkin"
            age = 28
        }

    }
}