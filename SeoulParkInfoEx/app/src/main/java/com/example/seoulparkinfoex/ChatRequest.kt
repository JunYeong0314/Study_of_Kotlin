package com.example.seoulparkinfoex


import com.squareup.moshi.Json

data class ChatRequest(
    @Json(name = "content")
    val content: String?
)