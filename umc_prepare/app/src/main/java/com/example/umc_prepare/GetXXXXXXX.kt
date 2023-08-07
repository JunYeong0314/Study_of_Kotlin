package com.example.umc_prepare


import com.squareup.moshi.Json

data class GetXXXXXXX(
    @Json(name = "operationId")
    val operationId: String?,
    @Json(name = "responses")
    val responses: ResponsesXXXXXXXXXXXX?,
    @Json(name = "tags")
    val tags: List<String>?
)