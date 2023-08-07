package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXXXXXXXXXX(
    @Json(name = "page")
    val page: Page?,
    @Json(name = "size")
    val size: SizeX?,
    @Json(name = "sort")
    val sort: SortX?
)