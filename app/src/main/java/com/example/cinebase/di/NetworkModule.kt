package com.example.cinebase.di

import com.example.domain.cinebase.ICineRepository
import com.example.domain.cinebase.nowplaying.usecase.GetCineNowPlayingUseCase
import com.example.network.CineRepository
import com.example.network.remote.CineRemoteData
import com.example.network.remote.ICineRemoteData
import com.example.network.remote.api.ICineApiClient
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
    fun getRetrofitBuild(): ICineApiClient {

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
            .create(ICineApiClient::class.java)
    }

    @Provides
    @Singleton
    fun provideCineRemoteData(apiClient: ICineApiClient) : ICineRemoteData {
        return CineRemoteData(apiClient)
    }

    @Provides
    @Singleton
    fun provideRepository(cineRemoteData: CineRemoteData) : ICineRepository {
        return CineRepository(cineRemoteData)
    }

    @Provides
    @Singleton
    fun provideGetCineNowPlayingUseCase(cineRepository: CineRepository) = GetCineNowPlayingUseCase(cineRepository)

}