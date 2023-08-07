package com.example.umc_prepare


import com.squareup.moshi.Json

data class Apiarticlessearch(
    @Json(name = "get")
    val `get`: GetX?
)