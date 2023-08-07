package com.example.umc_prepare


import com.squareup.moshi.Json

data class ResponseCustomChatResponse(
    @Json(name = "properties")
    val properties: PropertiesXXXXXXXXXXXXXX?,
    @Json(name = "type")
    val type: String?
)