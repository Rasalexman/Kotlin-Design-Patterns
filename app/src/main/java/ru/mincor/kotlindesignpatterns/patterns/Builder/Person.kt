package ru.mincor.kotlindesignpatterns.patterns.Builder

class Person private constructor(val name: String, val surname: String, val age: Int) {

    private constructor(builder: Builder) : this(builder.name, builder.surname, builder.age)

    companion object {
        fun create(init: Builder.() -> Unit) = Builder(init).build()
    }

    class Builder private constructor() {

        constructor(init: Builder.() -> Unit) : this() {
            init()
        }

        var name: String = ""       // or you can use lateinit but not recomended
        var surname: String = ""    // or you can use lateinit but not recomended
        var age: Int = 0

        fun name(init: Builder.() -> String) = apply { name = init() }
        fun surname(init: Builder.() -> String) = apply { surname = init() }
        fun age(init: Builder.() -> Int) = apply { age = init() }
        fun build() = Person(this)
    }
}