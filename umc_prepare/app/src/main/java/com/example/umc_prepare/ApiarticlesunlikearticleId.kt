package com.example.umc_prepare


import com.squareup.moshi.Json

data class ApiarticlesunlikearticleId(
    @Json(name = "delete")
    val delete: Delete?
)