package com.example.umc_prepare


import com.squareup.moshi.Json

data class GetXXXXXX(
    @Json(name = "description")
    val description: String?,
    @Json(name = "operationId")
    val operationId: String?,
    @Json(name = "responses")
    val responses: ResponsesXXXXXXXXXXX?,
    @Json(name = "summary")
    val summary: String?,
    @Json(name = "tags")
    val tags: List<String>?
)