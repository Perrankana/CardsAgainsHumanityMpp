package com.pandiandcode.mpp.cardsagainsthumanity

expect fun platformName(): String

fun createApplicationScreenMessage(): String {
    return "Kotlin Rocks on ${platformName()}"
}

