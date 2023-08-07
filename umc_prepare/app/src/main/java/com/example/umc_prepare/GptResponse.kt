package com.example.umc_prepare


import com.squareup.moshi.Json

data class GptResponse(
    @Json(name = "description")
    val description: String?,
    @Json(name = "properties")
    val properties: PropertiesXXXXXX?,
    @Json(name = "type")
    val type: String?
)