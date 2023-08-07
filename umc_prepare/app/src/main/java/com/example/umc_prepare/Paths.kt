package com.example.umc_prepare


import com.squareup.moshi.Json

data class Paths(
    @Json(name = "/api/articles/detail/{articleId}")
    val apiarticlesdetailarticleId: ApiarticlesdetailarticleId?,
    @Json(name = "/api/articles/like/{articleId}")
    val apiarticleslikearticleId: ApiarticleslikearticleId?,
    @Json(name = "/api/articles/new")
    val apiarticlesnew: Apiarticlesnew?,
    @Json(name = "/api/articles/search")
    val apiarticlessearch: Apiarticlessearch?,
    @Json(name = "/api/articles/search/industry")
    val apiarticlessearchindustry: Apiarticlessearchindustry?,
    @Json(name = "/api/articles/search/keyword")
    val apiarticlessearchkeyword: Apiarticlessearchkeyword?,
    @Json(name = "/api/articles/unlike/{articleId}")
    val apiarticlesunlikearticleId: ApiarticlesunlikearticleId?,
    @Json(name = "/api/chat/")
    val apichat: Apichat?,
    @Json(name = "/api/chat/qna")
    val apichatqna: Apichatqna?,
    @Json(name = "/api/chat/select/{articleId}")
    val apichatselectarticleId: ApichatselectarticleId?,
    @Json(name = "/api/members/me")
    val apimembersme: Apimembersme?,
    @Json(name = "/logout")
    val logout: Logout?,
    @Json(name = "/profile")
    val profile: ProfileX?,
    @Json(name = "/signup")
    val signup: Signup?
)