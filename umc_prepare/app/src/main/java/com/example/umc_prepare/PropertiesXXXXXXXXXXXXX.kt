package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXXXXXXXXXXXX(
    @Json(name = "chatId")
    val chatId: ChatIdX?,
    @Json(name = "question")
    val question: Question?
)