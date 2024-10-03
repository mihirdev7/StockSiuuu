### Stock Lookup App

This is a simple Android application that allows users to search for a stock symbol and view its current price, percentage change, and company details using real-time stock market data. The app uses the Yahoo Finance API to get real-time stock data.

#### Features:
- Search for a stock symbol (e.g., AAPL, TSLA).
- Display the current stock price, percentage change, and company name.
- Use Retrofit to fetch data from the Yahoo Finance API.
- Handle loading states and basic errors (e.g., invalid symbol, network issues).

#### Tech Stack:
- **Kotlin**: Main programming language.
- **Retrofit**: For handling API requests.
- **MVVM Architecture**: For separating UI and business logic.
- **LiveData**: For observing data changes in the UI.

#### How It Works:
1. **Constants Class**: Holds the API key, base URL, and headers.
2. **Retrofit API Service**: Handles the network calls using the constants.
3. **ViewModel**: Fetches stock data and updates the UI.
4. **MainActivity**: Displays stock details and handles user interactions. 
