package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXXXXXXXXXXXXXXXXX(
    @Json(name = "data")
    val `data`: DataXXXX?,
    @Json(name = "description")
    val description: DescriptionXXXX?,
    @Json(name = "status")
    val status: StatusXXXX?,
    @Json(name = "statusCode")
    val statusCode: StatusCodeXXXX?,
    @Json(name = "transaction_time")
    val transactionTime: TransactionTimeXXXX?
)