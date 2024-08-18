package com.example.stocksapp.data.repository

import com.example.stocksapp.data.local.StockDatabase
import com.example.stocksapp.data.mapper.toCompanyListing
import com.example.stocksapp.data.remote.StockApi
import com.example.stocksapp.domain.model.CompanyListing
import com.example.stocksapp.domain.repository.StockRepository
import com.example.stocksapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    val api: StockApi,
    val db: StockDatabase
) : StockRepository {

    private val dao = db.dao

    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {
        return flow{
            emit(Resource.Loading(true))
            val localListings = dao.searchCompanyListing(query)
            emit(Resource.Success(
                data = localListings.map { it.toCompanyListing() }
            ))

            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote

            if(shouldJustLoadFromCache){
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteListings = try{
                val response = api.getListing(query)
                val csvReader = CSVReader(InputStreamReader())
                response.byteStream()
            }catch(e: HttpException){
                emit(Resource.Error("Couldn't load data"))
            }catch (e: IOException){
                emit(Resource.Error("Couldn't load data"))
            }
        }
    }

}