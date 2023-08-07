package com.example.umc_prepare


import com.squareup.moshi.Json

data class ResponseCustomLong(
    @Json(name = "properties")
    val properties: PropertiesXXXXXXXXXXXXXXXXX?,
    @Json(name = "type")
    val type: String?
)