package com.example.umc_prepare


import com.squareup.moshi.Json

data class Parameter(
    @Json(name = "description")
    val description: String?,
    @Json(name = "in")
    val inX: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "required")
    val required: Boolean?,
    @Json(name = "schema")
    val schema: Schema?
)