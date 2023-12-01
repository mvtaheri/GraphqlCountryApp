package com.vahid.graphqlapp.data

import com.apollographql.apollo3.ApolloClient
import com.plcoding.CountriesQuery
import com.plcoding.CountryQuery
import com.vahid.graphqlapp.domain.CountryClient
import com.vahid.graphqlapp.domain.DetailedCountry
import com.vahid.graphqlapp.domain.SimpleCountry

class ApolloCountryClient(
    private val apolloCilent: ApolloClient
) : CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloCilent.query(
            CountriesQuery()
        ).execute()
            .data
            ?.countries
            ?.map { it.toSimpleCoutry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloCilent
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}