package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXXXXXXXXXXXXX(
    @Json(name = "data")
    val `data`: Data?,
    @Json(name = "description")
    val description: Description?,
    @Json(name = "status")
    val status: Status?,
    @Json(name = "statusCode")
    val statusCode: StatusCode?,
    @Json(name = "transaction_time")
    val transactionTime: TransactionTime?
)