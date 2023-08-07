package com.example.umc_prepare


import com.squareup.moshi.Json

data class Signup(
    @Json(name = "post")
    val post: PostXXXX?
)