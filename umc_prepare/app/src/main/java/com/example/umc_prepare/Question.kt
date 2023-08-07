package com.example.umc_prepare


import com.squareup.moshi.Json

data class Question(
    @Json(name = "description")
    val description: String?,
    @Json(name = "type")
    val type: String?
)