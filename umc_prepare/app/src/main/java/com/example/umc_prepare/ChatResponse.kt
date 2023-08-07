package com.example.umc_prepare


import com.squareup.moshi.Json

data class ChatResponse(
    @Json(name = "description")
    val description: String?,
    @Json(name = "properties")
    val properties: PropertiesX?,
    @Json(name = "type")
    val type: String?
)