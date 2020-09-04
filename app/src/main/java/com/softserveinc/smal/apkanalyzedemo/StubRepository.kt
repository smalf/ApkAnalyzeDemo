package com.softserveinc.smal.apkanalyzedemo

class PeopleRepository {

    fun getPeople(token: String): List<Person> {
        //Just create stub list with data.
        return listOf(Person(1, "Joey"),
            Person(2, "Phoebe"),
            Person(3, "Chandler"),
            Person(4, "Monica"),
            Person(5, "Ross"),
            Person(6, "Rachel"))
    }
}

data class Person(val id: Int, val name: String)