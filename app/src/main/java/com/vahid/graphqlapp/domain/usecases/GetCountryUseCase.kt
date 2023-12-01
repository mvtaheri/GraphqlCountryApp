package com.vahid.graphqlapp.domain.usecases

import com.vahid.graphqlapp.domain.CountryClient
import com.vahid.graphqlapp.domain.DetailedCountry

class GetCountryUseCase(
    private val countryClient: CountryClient
) {
    suspend fun execute(code: String): DetailedCountry? {
        return countryClient.getCountry(code)
    }
}