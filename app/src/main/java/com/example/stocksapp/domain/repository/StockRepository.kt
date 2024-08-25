package com.example.stocksapp.domain.repository

import com.example.stocksapp.domain.model.CompanyInfo
import com.example.stocksapp.domain.model.CompanyListing
import com.example.stocksapp.domain.model.IntradayInfo
import com.example.stocksapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {
    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>

    suspend fun getIntradayInfo(
        symbol: String
    ): Resource<List<IntradayInfo>>

    suspend fun getCompanyInfo(
        symbol: String
    ): Resource<CompanyInfo>
}