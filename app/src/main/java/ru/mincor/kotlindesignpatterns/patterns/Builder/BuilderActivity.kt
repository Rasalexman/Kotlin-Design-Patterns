package ru.mincor.kotlindesignpatterns.patterns.Builder

import android.os.Bundle
import ru.mincor.kotlindesignpatterns.activity.BackActivity

class BuilderActivity : BackActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "BUILDER PATTERN EXAMPLE"

        val personStatic1 = Person.create {
            name { "Alexander" }
            surname { "Minkin" }
            age { 31 }
        }
        println(personStatic1.toString())

        // OR
        val personStatic2 = Person.create {
            name = "Vladimir"
            surname = "Minkin"
            age = 32
        }
        println(personStatic2.toString())

        // OR DSL
        val personDSL = person {
            personData {
                firstName = "Alexander"
                secondName = "Minkin"
                age = 31
            }

            job {
                jobName = "FortGroup"
                jobAddress = "Saint-Petersburg, Russia"
            }

            social {
                network = "VK"
                id = "347435"
            }
        }

        println(personDSL.toPersonString())
    }
}