package com.example.stocksapp.data.csv

import com.example.stocksapp.domain.model.CompanyListing
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CompanyListingsParser @Inject constructor(): CSVParser<CompanyListing>{
    override suspend fun parse(stream: InputStream): List<CompanyListing> {
        val csvReader = CSVReader(InputStreamReader(stream))
        return withContext(Dispatchers.IO){
            csvReader.readAll()
                .drop(1)
                .mapNotNull { line ->
                    val symbol = line.getOrNull(0)
                    val name = line.getOrNull(1)
                    val exchange = line.getOrNull(2)
                }
        }
    }
}