package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXXXXXXXXXXXXXXXXXXXXX(
    @Json(name = "empty")
    val empty: EmptyX?,
    @Json(name = "sorted")
    val sorted: Sorted?,
    @Json(name = "unsorted")
    val unsorted: Unsorted?
)