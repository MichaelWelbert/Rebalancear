package com.example.rebalancear.data.yahoofinance

interface IMarket {
    suspend fun getStockPrice(stock: Stock): Double?
}