package com.example.umc_prepare


import com.squareup.moshi.Json

data class Delete(
    @Json(name = "description")
    val description: String?,
    @Json(name = "operationId")
    val operationId: String?,
    @Json(name = "parameters")
    val parameters: List<ParameterXXXXX>?,
    @Json(name = "responses")
    val responses: ResponsesXXXXXX?,
    @Json(name = "summary")
    val summary: String?,
    @Json(name = "tags")
    val tags: List<String>?
)