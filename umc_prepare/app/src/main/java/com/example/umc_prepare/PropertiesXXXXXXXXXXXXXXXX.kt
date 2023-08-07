package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXXXXXXXXXXXXXXX(
    @Json(name = "data")
    val `data`: DataXX?,
    @Json(name = "description")
    val description: DescriptionXX?,
    @Json(name = "status")
    val status: StatusXX?,
    @Json(name = "statusCode")
    val statusCode: StatusCodeXX?,
    @Json(name = "transaction_time")
    val transactionTime: TransactionTimeXX?
)