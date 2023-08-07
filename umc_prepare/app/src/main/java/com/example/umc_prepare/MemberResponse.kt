package com.example.umc_prepare


import com.squareup.moshi.Json

data class MemberResponse(
    @Json(name = "properties")
    val properties: PropertiesXXXXXXXXX?,
    @Json(name = "type")
    val type: String?
)