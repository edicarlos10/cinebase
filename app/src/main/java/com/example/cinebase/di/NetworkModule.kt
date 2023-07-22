package com.example.cinebase.di

import com.example.network.remote.api.ICinebaseApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun getCineApiClientService(): ICinebaseApiClient {

        val httpInterceptor = HttpLoggingInterceptor()
        httpInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return Retrofit.Builder()
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(httpInterceptor).build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .build()
            .create(ICinebaseApiClient::class.java)
    }
}