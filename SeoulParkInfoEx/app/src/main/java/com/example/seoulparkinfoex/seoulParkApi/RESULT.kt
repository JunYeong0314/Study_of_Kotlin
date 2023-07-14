package com.example.seoulparkinfoex.seoulParkApi


import com.squareup.moshi.Json

data class RESULT(
    @field:Json(name = "CODE")
    val cODE: String?,
    @field:Json(name = "MESSAGE")
    val mESSAGE: String?
)