package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXXXX(
    @Json(name = "articlePhoto")
    val articlePhoto: ArticlePhoto?,
    @Json(name = "content")
    val content: ContentX?,
    @Json(name = "publisher")
    val publisher: PublisherX?,
    @Json(name = "reporter")
    val reporter: ReporterX?,
    @Json(name = "title")
    val title: TitleX?,
    @Json(name = "uploadedAt")
    val uploadedAt: UploadedAtX?
)