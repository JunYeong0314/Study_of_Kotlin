package com.example.umc_prepare


import com.squareup.moshi.Json

data class PropertiesXXXXXXXXXXXXXXX(
    @Json(name = "data")
    val `data`: DataX?,
    @Json(name = "description")
    val description: DescriptionX?,
    @Json(name = "status")
    val status: StatusX?,
    @Json(name = "statusCode")
    val statusCode: StatusCodeX?,
    @Json(name = "transaction_time")
    val transactionTime: TransactionTimeX?
)