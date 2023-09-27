package com.example.app.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import java.io.IOException
import javax.inject.Inject

class WebSearchRepository @Inject constructor() {

    suspend fun fetchPriceFromWeb(code: String): String? {
        return withContext(Dispatchers.IO) {
            val codeFormated = "$code.SA"

            try {
                val doc = Jsoup.connect("https://finance.yahoo.com/quote/$codeFormated").get()
                val element = doc.select("td[data-test='OPEN-value']").first()
                element?.text()

            } catch (e: IOException) {
                e.printStackTrace()
                null
            }
        }
    }

}