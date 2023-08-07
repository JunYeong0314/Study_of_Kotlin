package com.example.umc_prepare


import com.squareup.moshi.Json

data class SearchArticleRes(
    @Json(name = "properties")
    val properties: PropertiesXXXXXXXXXXXXXXXXXXXX?,
    @Json(name = "type")
    val type: String?
)