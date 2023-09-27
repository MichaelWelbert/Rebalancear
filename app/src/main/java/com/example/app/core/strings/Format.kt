package com.example.app.core.strings

object Format {
    fun convertFloatToPriceFormat(price: Float) : String {
        val formatted = String.format("%.2f", price).replace('.', ',')
        return "R$$formatted"
    }
}