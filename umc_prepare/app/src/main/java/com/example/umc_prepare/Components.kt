package com.example.umc_prepare


import com.squareup.moshi.Json

data class Components(
    @Json(name = "schemas")
    val schemas: Schemas?,
    @Json(name = "securitySchemes")
    val securitySchemes: SecuritySchemes?
)