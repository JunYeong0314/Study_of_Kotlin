package com.example.umc_prepare


import com.squareup.moshi.Json

data class LoginMember(
    @Json(name = "properties")
    val properties: PropertiesXXXXXXXX?,
    @Json(name = "type")
    val type: String?
)