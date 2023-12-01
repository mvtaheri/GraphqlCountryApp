package com.vahid.graphqlapp.di

import com.apollographql.apollo3.ApolloClient
import com.vahid.graphqlapp.data.ApolloCountryClient
import com.vahid.graphqlapp.domain.CountryClient
import com.vahid.graphqlapp.domain.usecases.GetCountriesUseCase
import com.vahid.graphqlapp.domain.usecases.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient): CountryClient {
        return ApolloCountryClient(apolloClient)
    }
    @Provides
    @Singleton
    fun provideGetCountriesUseCase(countryClient: CountryClient):GetCountriesUseCase{
        return GetCountriesUseCase(countryClient)
    }


    @Provides
    @Singleton
    fun provideGetCountryUseCase(countryClient: CountryClient):GetCountryUseCase{
        return GetCountryUseCase(countryClient)
    }
}