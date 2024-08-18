package com.example.stocksapp.data.mapper

import com.example.stocksapp.data.local.CompanyListingEntity
import com.example.stocksapp.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity() : CompanyListingEntity{
    return  CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}