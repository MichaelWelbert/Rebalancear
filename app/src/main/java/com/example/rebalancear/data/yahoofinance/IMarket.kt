package com.example.rebalancear.data.yahoofinance

interface IMarket {
    suspend fun getStock(code: String): Stock?
}