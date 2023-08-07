package com.example.umc_prepare


import com.squareup.moshi.Json

data class Apichat(
    @Json(name = "post")
    val post: PostXX?
)