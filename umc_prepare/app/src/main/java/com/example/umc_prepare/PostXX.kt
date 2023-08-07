package com.example.umc_prepare


import com.squareup.moshi.Json

data class PostXX(
    @Json(name = "description")
    val description: String?,
    @Json(name = "operationId")
    val operationId: String?,
    @Json(name = "requestBody")
    val requestBody: RequestBodyX?,
    @Json(name = "responses")
    val responses: ResponsesXXXXXXX?,
    @Json(name = "summary")
    val summary: String?,
    @Json(name = "tags")
    val tags: List<String>?
)