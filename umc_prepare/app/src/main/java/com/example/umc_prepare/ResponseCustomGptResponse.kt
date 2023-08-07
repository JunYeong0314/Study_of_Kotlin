package com.example.umc_prepare


import com.squareup.moshi.Json

data class ResponseCustomGptResponse(
    @Json(name = "properties")
    val properties: PropertiesXXXXXXXXXXXXXXXX?,
    @Json(name = "type")
    val type: String?
)