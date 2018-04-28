package ru.mincor.kotlindesignpatterns.patterns.Builder

class PersonBuilder() {

    var jobHolder: PersonJob? = null
    var personDataHolder: PersonData? = null
    var socialInfoHolder: SocialInfo? = null

    constructor(init: PersonBuilder.() -> Unit) : this() {
        init()
    }

    fun job(init: PersonJob.() -> Unit) {
        jobHolder = object : PersonJob {
            override var jobName: String? = ""
                set(value) { field = value?:field }
            override var jobAddress: String? = ""
                set(value) { field = value?:field }
        }.apply(init)
    }

    fun personData(init: PersonData.() -> Unit) {
        // You can put default values to create person data and if input value can be null it replace with default value
        personDataHolder = object : PersonData {
            override var firstName: String? = ""
                set(value) { field = value?:field }
            override var secondName: String? = ""
                set(value) { field = value?:field }
            override var age: Int? = 0
                set(value) { field = value?:field }
        }.apply(init)
    }

    fun social(init: SocialInfo.() -> Unit) {
        socialInfoHolder = object : SocialInfo {
            override var network: String? = ""
                set(value) { field = value?:field }
            override var id: String? = ""
                set(value) { field = value?:field }
        }.apply(init)
    }

    fun build(): IPerson = object : IPerson {
        override var firstName: String? = personDataHolder?.firstName
        override var secondName: String? = personDataHolder?.secondName
        override var age: Int? = personDataHolder?.age

        override var jobName: String? = jobHolder?.jobName
        override var jobAddress: String? = jobHolder?.jobAddress

        override var network: String? = socialInfoHolder?.network
        override var id: String? = socialInfoHolder?.id
    }
}

interface PersonJob {
    var jobName: String?
    var jobAddress: String?
}

interface PersonData {
    var firstName: String?
    var secondName: String?
    var age: Int?
}

interface SocialInfo {
    var network: String?
    var id: String?
}

interface IPerson : PersonJob, PersonData, SocialInfo

fun person(init: PersonBuilder.() -> Unit): IPerson {
    return PersonBuilder(init).build()
}

fun IPerson.toPersonString(): String {
    return "firstName: $firstName, secondName: $secondName, age: $age, jobName: $jobName, jobAddress: $jobAddress, network: $network, id: $id"
}
