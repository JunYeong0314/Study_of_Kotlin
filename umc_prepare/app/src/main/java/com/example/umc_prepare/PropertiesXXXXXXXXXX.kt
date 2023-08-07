package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXXXXXXXXX(
    @Json(name = "content")
    val content: ContentXX?,
    @Json(name = "empty")
    val empty: Empty?,
    @Json(name = "first")
    val first: FirstX?,
    @Json(name = "last")
    val last: Last?,
    @Json(name = "number")
    val number: Number?,
    @Json(name = "numberOfElements")
    val numberOfElements: NumberOfElements?,
    @Json(name = "pageable")
    val pageable: Pageable?,
    @Json(name = "size")
    val size: Size?,
    @Json(name = "sort")
    val sort: Sort?,
    @Json(name = "totalElements")
    val totalElements: TotalElements?,
    @Json(name = "totalPages")
    val totalPages: TotalPages?
)