package com.example.umc_prepare


import com.squareup.moshi.Json

data class PageableObject(
    @Json(name = "properties")
    val properties: PropertiesXXXXXXXXXXXX?,
    @Json(name = "type")
    val type: String?
)