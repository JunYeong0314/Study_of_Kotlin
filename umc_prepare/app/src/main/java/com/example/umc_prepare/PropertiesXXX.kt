package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXX(
    @Json(name = "articlePhotos")
    val articlePhotos: ArticlePhotos?,
    @Json(name = "content")
    val content: Content?,
    @Json(name = "industry")
    val industry: Industry?,
    @Json(name = "publisher")
    val publisher: Publisher?,
    @Json(name = "reporter")
    val reporter: Reporter?,
    @Json(name = "title")
    val title: Title?,
    @Json(name = "uploadedAt")
    val uploadedAt: UploadedAt?
)