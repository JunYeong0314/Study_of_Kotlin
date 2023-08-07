package com.example.umc_prepare


import com.squareup.moshi.Json

data class SortObject(
    @Json(name = "properties")
    val properties: PropertiesXXXXXXXXXXXXXXXXXXXXXX?,
    @Json(name = "type")
    val type: String?
)