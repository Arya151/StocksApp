package com.example.stocksapp.presentation.company_info

import com.example.stocksapp.domain.model.CompanyInfo
import com.example.stocksapp.domain.model.IntradayInfo

data class CompanyInfoState (
    val stockInfos: List<IntradayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
