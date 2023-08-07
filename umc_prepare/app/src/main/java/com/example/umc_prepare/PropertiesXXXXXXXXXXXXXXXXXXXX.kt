package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXXXXXXXXXXXXXXXXXXX(
    @Json(name = "articlePhoto")
    val articlePhoto: ArticlePhotoX?,
    @Json(name = "content")
    val content: ContentXXX?,
    @Json(name = "publisher")
    val publisher: PublisherXX?,
    @Json(name = "reporter")
    val reporter: ReporterXX?,
    @Json(name = "title")
    val title: TitleXX?,
    @Json(name = "uploadedAt")
    val uploadedAt: UploadedAtXX?
)