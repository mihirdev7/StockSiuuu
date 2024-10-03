package com.example.stocksiuuu.Api

import com.example.stocksiuuu.Model.StockResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface StockApiService {
    @GET("api/stock/get-price")
    suspend fun getStockData(
        @Query("region") region: String,
        @Query("symbol") symbol: String,
        @Header("x-rapidapi-key") apiKey: String,
        @Header("x-rapidapi-host") apiHost: String
    ): Response<StockResponse>
}