package com.example.stocksapp.presentation.company_listing

sealed class CompanyListingsEvent{
    object Refresh: CompanyListingsEvent()
    data class OnSearchQueryChange(val query: String): CompanyListingsEvent()
}
