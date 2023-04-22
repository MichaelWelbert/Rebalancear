package com.example.rebalancear.data.yahoofinance

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class YahooFinanceClient(apiKey: String) :IMarket {
    private val api: YahooFinanceApi = Retrofit.Builder()
        .baseUrl("https://apidojo-yahoo-finance-v1.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader("x-rapidapi-key", apiKey)
                .addHeader("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .build()
            chain.proceed(request)
        }.build())
        .build()
        .create(YahooFinanceApi::class.java)

    override suspend fun getStockPrice(stock: Stock): Double? {
        val response = api.getQuotes(stock.toString(), region = "BR", lang = "pt-BR")
        if (!response.isSuccessful) {
            throw ApiException(response.code())
        }

        val quotes = response.body()?.quoteResponse?.quotes ?: emptyList()
        val quote = quotes.firstOrNull { it.symbol == stock.toString() }
        return quote?.price
    }
}

class ApiException(val code: Int) : Exception()

class SymbolNotFoundException(val symbol: String) : Exception()