package com.example.stocksiuuu.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stocksiuuu.Api.RetrofitInstance
import com.example.stocksiuuu.Constants.NetworkConstants
import com.example.stocksiuuu.Model.StockResponse
import kotlinx.coroutines.launch

class StockViewModel : ViewModel() {
    val stockData = MutableLiveData<StockResponse>()
    val errorMessage = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()

    fun fetchStockData(symbol: String) {
        loading.value = true
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getStockData(NetworkConstants.REGION, symbol, NetworkConstants.API_KEY, NetworkConstants.API_HOST)
                if (response.isSuccessful) {
                    stockData.value = response.body()
                } else {
                    errorMessage.value = "Invalid stock symbol"
                }
            } catch (e: Exception) {
                errorMessage.value = "Network error"
            }
            loading.value = false
        }
    }
}
