package com.vahid.graphqlapp.data

import com.plcoding.CountriesQuery
import com.plcoding.CountryQuery
import com.vahid.graphqlapp.domain.DetailedCountry
import com.vahid.graphqlapp.domain.SimpleCountry
import okhttp3.internal.notifyAll

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "no capital",
        currency = currency ?: "no currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name

    )
}
fun CountriesQuery.Country.toSimpleCoutry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "no capital"
    )
}