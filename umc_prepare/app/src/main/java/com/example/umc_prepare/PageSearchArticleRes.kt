package com.example.umc_prepare


import com.squareup.moshi.Json

data class PageSearchArticleRes(
    @Json(name = "properties")
    val properties: PropertiesXXXXXXXXXX?,
    @Json(name = "type")
    val type: String?
)