package com.example.umc_prepare


import com.squareup.moshi.Json

data class DetailArticleRes(
    @Json(name = "properties")
    val properties: PropertiesXXXXX?,
    @Json(name = "type")
    val type: String?
)