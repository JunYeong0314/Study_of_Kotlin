package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXXXXXXXXXXX(
    @Json(name = "offset")
    val offset: Offset?,
    @Json(name = "pageNumber")
    val pageNumber: PageNumber?,
    @Json(name = "pageSize")
    val pageSize: PageSize?,
    @Json(name = "paged")
    val paged: Paged?,
    @Json(name = "sort")
    val sort: SortXX?,
    @Json(name = "unpaged")
    val unpaged: Unpaged?
)