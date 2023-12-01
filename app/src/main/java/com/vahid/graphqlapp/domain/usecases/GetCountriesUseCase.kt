package com.vahid.graphqlapp.domain.usecases

import com.vahid.graphqlapp.domain.CountryClient
import com.vahid.graphqlapp.domain.SimpleCountry

class GetCountriesUseCase(
    private val countryClient: CountryClient
) {
    suspend fun execute(): List<SimpleCountry> {
        return countryClient.getCountries()
            .sortedBy { it.name }
    }
}