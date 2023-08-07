package com.example.umc_prepare


import com.squareup.moshi.Json

data class QuestionRequest(
    @Json(name = "description")
    val description: String?,
    @Json(name = "properties")
    val properties: PropertiesXXXXXXXXXXXXX?,
    @Json(name = "type")
    val type: String?
)