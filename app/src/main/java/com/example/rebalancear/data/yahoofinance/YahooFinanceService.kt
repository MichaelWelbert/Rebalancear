package com.example.rebalancear.data.yahoofinance

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface YahooFinanceApi {
    @GET("market/v2/get-quotes")
    suspend fun getQuotes(
        @Query("symbols") symbols: String,
        @Query("region") region: String = "US",
        @Query("lang") lang: String = "en-US"
    ): Response<YahooFinanceResponse>
}

data class YahooFinanceResponse(
    @SerializedName("quoteResponse")
    val quoteResponse: QuoteResponse
)

data class QuoteResponse(
    @SerializedName("result")
    val quotes: List<Quote>,
    @SerializedName("error")
    val error: Error?
)

data class Quote(
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("regularMarketPrice")
    val price: Double
)

data class Error(
    @SerializedName("code")
    val code: String,
    @SerializedName("description")
    val description: String
)

data class Stock(
    val symbol: String,
    val exchange: String = "SA",
    val currency: String = "BRL"
) {
    override fun toString(): String {
        return "$symbol.$exchange"
    }
}