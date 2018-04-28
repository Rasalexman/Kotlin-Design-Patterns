package ru.mincor.kotlindesignpatterns.patterns.builder

class Person private constructor(private val name: String, private val surname: String, private val age: Int) {

    private constructor(builder: Builder) : this(builder.name, builder.surname, builder.age)

    companion object {
        fun create(init: Builder.() -> Unit) = Builder(init).build()
    }

    override fun toString(): String {
        return "name: $name, surname: $surname, age: $age"
    }

    class Builder private constructor() {

        constructor(init: Builder.() -> Unit) : this() {
            init()
        }

        var name: String = ""       // or you can use lateinit but not i'm recommend to use this
        var surname: String = ""    // or you can use lateinit but not i'm recommend to use this
        var age: Int = 0

        fun name(init: Builder.() -> String) = apply { name = init() }
        fun surname(init: Builder.() -> String) = apply { surname = init() }
        fun age(init: Builder.() -> Int) = apply { age = init() }
        fun build() = Person(this)
    }
}