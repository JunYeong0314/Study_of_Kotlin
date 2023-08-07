package com.example.umc_prepare


import com.squareup.moshi.Json

data class PostXXX(
    @Json(name = "description")
    val description: String?,
    @Json(name = "operationId")
    val operationId: String?,
    @Json(name = "requestBody")
    val requestBody: RequestBodyXX?,
    @Json(name = "responses")
    val responses: ResponsesXXXXXXXX?,
    @Json(name = "summary")
    val summary: String?,
    @Json(name = "tags")
    val tags: List<String>?
)