package com.example.stocksapp.di

import com.example.stocksapp.data.csv.CSVParser
import com.example.stocksapp.data.csv.CompanyListingsParser
import com.example.stocksapp.data.csv.IntradayInfoParser
import com.example.stocksapp.data.repository.StockRepositoryImpl
import com.example.stocksapp.domain.model.CompanyListing
import com.example.stocksapp.domain.model.IntradayInfo
import com.example.stocksapp.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingParser(
        companyListingParser: CompanyListingsParser
    ): CSVParser<CompanyListing>


    @Binds
    @Singleton
    abstract fun bindIntradayInfoParser(
        intradayInfoParser: IntradayInfoParser
    ): CSVParser<IntradayInfo>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl : StockRepositoryImpl
    ): StockRepository

}