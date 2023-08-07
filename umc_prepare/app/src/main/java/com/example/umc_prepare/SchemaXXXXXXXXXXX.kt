package com.example.umc_prepare


import com.squareup.moshi.Json

data class SchemaXXXXXXXXXXX(
    @Json(name = "format")
    val format: String?,
    @Json(name = "$ref")
    val ref: String?,
    @Json(name = "type")
    val type: String?
)