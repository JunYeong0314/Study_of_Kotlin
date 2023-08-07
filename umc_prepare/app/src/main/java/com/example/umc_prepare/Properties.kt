package com.example.umc_prepare


import com.squareup.moshi.Json

data class Properties(
    @Json(name = "articleId")
    val articleId: ArticleId?,
    @Json(name = "memberId")
    val memberId: MemberId?
)