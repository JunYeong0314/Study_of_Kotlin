package com.example.umc_prepare


import com.squareup.moshi.Json

data class DetailArticlePhotoRes(
    @Json(name = "properties")
    val properties: PropertiesXXXX?,
    @Json(name = "type")
    val type: String?
)