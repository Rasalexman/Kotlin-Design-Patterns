package ru.mincor.kotlindesignpatterns.patterns.builder

/**
 * The builder pattern is used to create complex objects with constituent parts that must be created in the same order or using a specific algorithm.
 */

class PersonBuilder() {

    private var jobHolder: PersonJob? = null
    private var personDataHolder: PersonData? = null
    //private var socialInfoHolder: SocialInfo? = null

    private var socialInfos = mutableListOf<SocialInfo>()

    constructor(init: PersonBuilder.() -> Unit) : this() {
        init()
    }

    fun job(init: PersonJob.() -> Unit) {
        jobHolder = object : PersonJob {
            override var jobName: String? = ""
            override var jobAddress: String? = ""
        }.apply(init)
    }

    fun personData(init: PersonData.() -> Unit) {
        // You can put default values to create person data
        personDataHolder = object : PersonData {
            override var firstName: String? = ""
            override var secondName: String? = ""
            override var age: Int? = 0
            override var socialInfos: List<SocialInfo> = listOf()
        }.apply(init)
    }

    fun socials(init:SocialInfos.() -> Unit){
        socialInfos.addAll(SocialInfos().apply(init))
    }

    /*fun social(init: SocialInfo.() -> Unit) {
        socialInfoHolder = object : SocialInfo {
            override var network: String? = ""
            override var id: String? = ""
            override var nickName: String? = ""
        }.apply(init)
    }*/

    fun build(): IPerson = object : IPerson {
        override var firstName: String? = personDataHolder?.firstName
        override var secondName: String? = personDataHolder?.secondName
        override var age: Int? = personDataHolder?.age

        override var jobName: String? = jobHolder?.jobName
        override var jobAddress: String? = jobHolder?.jobAddress

        override var socialInfos: List<SocialInfo> = this@PersonBuilder.socialInfos
    }
}

class SocialInfoBuilder : SocialInfo {
    override var network: String? = ""
    override var id: String? = ""
    override var nickName: String? = ""

    fun build():SocialInfo = object : SocialInfo {
        override var network: String? = this@SocialInfoBuilder.network
        override var id: String? = this@SocialInfoBuilder.id
        override var nickName: String? = this@SocialInfoBuilder.nickName
    }
}

class SocialInfos : ArrayList<SocialInfo>(){
    fun social(init:SocialInfoBuilder.()->Unit) {
        add(SocialInfoBuilder().apply(init).build())
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
    var socialInfos:List<SocialInfo>
}

interface SocialInfo {
    var network: String?
    var id: String?
    var nickName:String?
}

interface IPerson : PersonJob, PersonData

fun person(init: PersonBuilder.() -> Unit): IPerson {
    return PersonBuilder(init).build()
}

fun IPerson.toPersonString(): String {
    var personString = "firstName: $firstName, secondName: $secondName, age: $age, jobName: $jobName, jobAddress: $jobAddress"
    socialInfos.forEach { personString +="\n SOCIAL INFO: network: ${it.network} id: ${it.id} nickName: ${it.nickName}" }
    return personString
}
