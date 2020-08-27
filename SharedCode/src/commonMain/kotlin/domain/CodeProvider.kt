package com.pandiandcode.mpp.cardsagainsthumanity.domain

interface CodeProvider{
    fun generateCode(): String
}

class CodeProviderImpl(): CodeProvider {
    override fun generateCode(): String  = getRandomString(6)

    private fun getRandomString(length: Int): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
}