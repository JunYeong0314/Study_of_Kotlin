package com.example.umc_prepare


import com.squareup.moshi.Json

data class IndustryKeyword(
    @Json(name = "properties")
    val properties: PropertiesXXXXXXX?,
    @Json(name = "type")
    val type: String?
)