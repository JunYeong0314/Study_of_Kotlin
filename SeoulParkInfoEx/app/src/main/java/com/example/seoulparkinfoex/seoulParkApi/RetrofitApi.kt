package com.example.seoulparkinfoex.seoulParkApi

import com.example.seoulparkinfoex.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class RetrofitApi {

    @Singleton
    @Provides
    fun getInstance(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(getOkHttpClient())
            .baseUrl(Constants.park_BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun getOkHttpClient(): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Singleton
    @Provides
    fun getSeoulParkService(retrofit: Retrofit): SeoulParkService{
        return retrofit.create(SeoulParkService::class.java)
    }
}