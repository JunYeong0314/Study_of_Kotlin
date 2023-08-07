package com.example.umc_prepare


import com.squareup.moshi.Json

data class SchemaXXXXXXXXX(
    @Json(name = "$ref")
    val ref: String?,
    @Json(name = "type")
    val type: String?
)