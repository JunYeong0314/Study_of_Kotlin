package com.example.seoulparkinfoex

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Streaming

interface ChatService {
    @POST("stream_chat")
    @Streaming
    suspend fun getChat(
        @Body request: ChatRequest
    ): Response<ResponseBody>
}