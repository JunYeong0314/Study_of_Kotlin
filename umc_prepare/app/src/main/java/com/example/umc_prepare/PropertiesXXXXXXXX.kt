package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXXXXXXX(
    @Json(name = "id")
    val id: Id?,
    @Json(name = "name")
    val name: Name?
)