package com.example.stocksiuuu.View

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.stocksiuuu.ViewModel.StockViewModel
import com.example.stocksiuuu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: StockViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener {
            val stockSymbol = binding.etStockSymbol.text.toString()
            if (stockSymbol.isNotEmpty()) {
                viewModel.fetchStockData(stockSymbol)
            } else {
                Toast.makeText(this, "Please enter a stock symbol", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.stockData.observe(this, Observer { stock ->
            stock?.quoteSummary?.let {
                binding.tvCompanyName.text ="Company Name: ${stock.quoteSummary.result[0].price.longName}"
                binding.tvStockPrice.text = "Price: ${stock.quoteSummary.result[0].price.postMarketPrice.fmt}"
                binding.tvStockChange.text = "Percentage Change: ${stock.quoteSummary.result[0].price.postMarketChangePercent.fmt}"
            }
        })

        viewModel.errorMessage.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })

        viewModel.loading.observe(this, Observer { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        })
    }
}
