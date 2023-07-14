package com.example.seoulparkinfoex.seoulParkApi

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SeoulParkService {
    @GET("{api_key}/json/GetParkInfo/1/50")
    suspend fun getDataCoroutine(
        @Path("api_key") api_key: String
    ): Response<SeoulPark>
}