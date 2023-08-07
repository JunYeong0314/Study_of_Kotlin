package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXXXXXXXXXXXXXXXXXXXXXX(
    @Json(name = "loginMember")
    val loginMember: LoginMemberX?,
    @Json(name = "request")
    val request: Request?
)