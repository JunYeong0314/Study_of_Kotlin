package com.example.umc_prepare


import com.squareup.moshi.Json

data class PageableX(
    @Json(name = "properties")
    val properties: PropertiesXXXXXXXXXXX?,
    @Json(name = "type")
    val type: String?
)