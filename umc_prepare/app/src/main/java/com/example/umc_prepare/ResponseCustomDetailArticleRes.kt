package com.example.umc_prepare


import com.squareup.moshi.Json

data class ResponseCustomDetailArticleRes(
    @Json(name = "properties")
    val properties: PropertiesXXXXXXXXXXXXXXX?,
    @Json(name = "type")
    val type: String?
)