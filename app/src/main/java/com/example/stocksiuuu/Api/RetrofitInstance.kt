package com.example.stocksiuuu.Api

import com.example.stocksiuuu.Constants.NetworkConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = NetworkConstants.BASE_URL

    val api: StockApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StockApiService::class.java)
    }
}
