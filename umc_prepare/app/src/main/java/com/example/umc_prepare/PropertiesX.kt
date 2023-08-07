package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesX(
    @Json(name = "chatId")
    val chatId: ChatId?,
    @Json(name = "greeting")
    val greeting: Greeting?
)