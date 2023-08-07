package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXXXXXXXXXXXXXXXX(
    @Json(name = "data")
    val `data`: DataXXX?,
    @Json(name = "description")
    val description: DescriptionXXX?,
    @Json(name = "status")
    val status: StatusXXX?,
    @Json(name = "statusCode")
    val statusCode: StatusCodeXXX?,
    @Json(name = "transaction_time")
    val transactionTime: TransactionTimeXXX?
)