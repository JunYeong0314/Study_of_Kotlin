package com.example.umc_prepare


import com.squareup.moshi.Json

data class ChatRequest(
    @Json(name = "description")
    val description: String?,
    @Json(name = "properties")
    val properties: Properties?,
    @Json(name = "type")
    val type: String?
)