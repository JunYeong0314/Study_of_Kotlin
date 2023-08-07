package com.example.umc_prepare


import com.squareup.moshi.Json

data class SignUpRequest(
    @Json(name = "properties")
    val properties: PropertiesXXXXXXXXXXXXXXXXXXXXX?,
    @Json(name = "type")
    val type: String?
)