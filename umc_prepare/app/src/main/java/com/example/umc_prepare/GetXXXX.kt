package com.example.umc_prepare


import com.squareup.moshi.Json

data class GetXXXX(
    @Json(name = "description")
    val description: String?,
    @Json(name = "operationId")
    val operationId: String?,
    @Json(name = "parameters")
    val parameters: List<ParameterXXXXXX>?,
    @Json(name = "responses")
    val responses: ResponsesXXXXXXXXX?,
    @Json(name = "summary")
    val summary: String?,
    @Json(name = "tags")
    val tags: List<String>?
)