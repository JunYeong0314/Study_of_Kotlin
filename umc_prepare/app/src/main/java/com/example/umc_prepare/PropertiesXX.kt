package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXX(
    @Json(name = "articleImgUrl")
    val articleImgUrl: ArticleImgUrl?
)