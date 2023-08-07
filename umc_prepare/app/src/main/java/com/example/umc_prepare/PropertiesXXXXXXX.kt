package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXXXXXX(
    @Json(name = "first")
    val first: First?,
    @Json(name = "second")
    val second: Second?,
    @Json(name = "third")
    val third: Third?
)