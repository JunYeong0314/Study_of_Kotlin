package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXXXXXXXXXXXXXXXXXX(
    @Json(name = "data")
    val `data`: DataXXXXX?,
    @Json(name = "description")
    val description: DescriptionXXXXX?,
    @Json(name = "status")
    val status: StatusXXXXX?,
    @Json(name = "statusCode")
    val statusCode: StatusCodeXXXXX?,
    @Json(name = "transaction_time")
    val transactionTime: TransactionTimeXXXXX?
)