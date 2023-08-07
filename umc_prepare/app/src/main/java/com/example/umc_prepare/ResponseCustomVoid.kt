package com.example.umc_prepare


import com.squareup.moshi.Json

data class ResponseCustomVoid(
    @Json(name = "properties")
    val properties: PropertiesXXXXXXXXXXXXXXXXXXX?,
    @Json(name = "type")
    val type: String?
)