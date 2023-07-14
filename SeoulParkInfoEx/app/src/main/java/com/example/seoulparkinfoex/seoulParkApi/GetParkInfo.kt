package com.example.seoulparkinfoex.seoulParkApi


import com.squareup.moshi.Json

data class GetParkInfo(
    @field:Json(name = "list_total_count")
    val listTotalCount: Int?,
    @field:Json(name = "RESULT")
    val rESULT: RESULT?,
    @field:Json(name = "row")
    val row: List<Row?>?
)