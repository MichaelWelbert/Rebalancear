package com.example.rebalancear.data.yahoofinance

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class YahooFinanceClient(apiKey: String) : IMarket {
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

    override suspend fun getStock(code: String): Stock {

        val response = api.getQuotes("${code.uppercase()}.SA", region = "BR")
        if (!response.isSuccessful) {
            throw ApiException(response.code())
        }
        val price = response.body()?.price?.marketPrice
        val info = response.body()?.info

        return Stock(
            symbol = code.uppercase(),
            price = price?.raw,
            LPA = info?.lpa?.raw,
            VPA = info?.vpa?.raw
        )
    }
}

class ApiException(val code: Int) : Exception()
