package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXXXXXXXX(
    @Json(name = "birthdate")
    val birthdate: Birthdate?,
    @Json(name = "gender")
    val gender: Gender?,
    @Json(name = "id")
    val id: IdX?,
    @Json(name = "industryKeyword")
    val industryKeyword: IndustryKeywordX?,
    @Json(name = "keywords")
    val keywords: Keywords?,
    @Json(name = "name")
    val name: NameX?
)