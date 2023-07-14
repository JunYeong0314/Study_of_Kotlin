package com.example.seoulparkinfoex.seoulParkApi


import com.squareup.moshi.Json

data class SeoulPark(
    @field:Json(name = "GetParkInfo")
    val getParkInfo: GetParkInfo?
)