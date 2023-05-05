package com.example.rebalancear.data.yahoofinance

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface YahooFinanceApi {
    @GET("stock/v2/get-summary")
    suspend fun getQuotes(
        @Query("symbol") symbol: String,
        @Query("region") region: String = "BR",
    ): Response<YahooFinanceResponse>
}

data class YahooFinanceResponse(
    @SerializedName("price")
    val price: Price,
    @SerializedName("defaultKeyStatistics")
    val info: Info
)

data class Price(
    @SerializedName("regularMarketPrice")
    val marketPrice: Format,
)

data class Info(
    @SerializedName("trailingEps")
    val lpa: Format,
    @SerializedName("bookValue")
    val vpa: Format,
)


data class Format(
    val raw: Double,
    val fmt: String
)


data class Stock(
    val symbol: String,
    val price: Double? = null,
    val LPA: Double? = null,
    val VPA: Double? = null,
)