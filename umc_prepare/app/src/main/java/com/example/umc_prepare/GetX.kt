package com.example.umc_prepare


import com.squareup.moshi.Json

data class GetX(
    @Json(name = "description")
    val description: String?,
    @Json(name = "operationId")
    val operationId: String?,
    @Json(name = "parameters")
    val parameters: List<ParameterXX>?,
    @Json(name = "responses")
    val responses: ResponsesXX?,
    @Json(name = "summary")
    val summary: String?,
    @Json(name = "tags")
    val tags: List<String>?
)