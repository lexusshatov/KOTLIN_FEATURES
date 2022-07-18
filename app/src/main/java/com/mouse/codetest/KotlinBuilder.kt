package com.mouse.codetest

@Suppress("DataClassPrivateConstructor")
data class School private constructor(
    val kitchen: Boolean,
    val hall: Boolean,
    val bathroom: Boolean,
) {
    companion object {
        operator fun invoke(block: SchoolBuilder.() -> Unit): School {
            val builder = SchoolBuilder()
            block.invoke(builder)
            return School(
                kitchen = builder.kitchen,
                hall = builder.hall,
                bathroom = builder.bathroom
            )
        }
    }

    class SchoolBuilder {
        var kitchen: Boolean = false
        var hall: Boolean = true
        var bathroom: Boolean = true
    }
}

fun main() {
    val school = School {
        kitchen = true
        bathroom = false
    }
    println(school)
}