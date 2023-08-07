package com.example.umc_prepare


import com.squareup.moshi.Json

data class Get(
    @Json(name = "description")
    val description: String?,
    @Json(name = "operationId")
    val operationId: String?,
    @Json(name = "parameters")
    val parameters: List<Parameter>?,
    @Json(name = "responses")
    val responses: Responses?,
    @Json(name = "summary")
    val summary: String?,
    @Json(name = "tags")
    val tags: List<String>?
)