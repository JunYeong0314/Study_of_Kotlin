package com.example.umc_prepare


import com.squareup.moshi.Json

data class ApiarticleslikearticleId(
    @Json(name = "post")
    val post: Post?
)