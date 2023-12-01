package com.vahid.graphqlapp.presentation

import com.vahid.graphqlapp.domain.DetailedCountry
import com.vahid.graphqlapp.domain.SimpleCountry

data class CountriesState(
    val countries: List<SimpleCountry> = emptyList(),
    val isLoading: Boolean = false,
    val selectedCountry: DetailedCountry? = null
)
