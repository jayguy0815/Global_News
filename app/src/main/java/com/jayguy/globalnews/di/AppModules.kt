package com.jayguy.globalnews.di

/**
 * Created by Leo on 2022/11/8.
 */

import com.jayguy.globalnews.domain.Service
import com.jayguy.globalnews.domain.repository.Repository
import com.jayguy.globalnews.domain.repository.RepositoryImpl
import com.jayguy.globalnews.utils.Injection.KEY_API
import com.jayguy.globalnews.utils.Injection.PAGE_SIZE
import com.jayguy.globalnews.utils.Injection.WEB_API
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class AppModules {

    @Provides
    @Named("WEB_API")
    fun provideWebAPI(): String = WEB_API

    @Provides
    @Named("KEY_API")
    fun provideKeyAPI(): String = KEY_API

    @Provides
    @Named("PAGE_SIZE")
    fun providePageSize(): Int = PAGE_SIZE

    @Provides
    fun provideRetrofit(
        @Named("WEB_API") webAPI: String,
    ): Retrofit {
        val client = OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
        return Retrofit.Builder()
            .baseUrl(webAPI)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun provideGamesService(
        retrofit: Retrofit
    ): Service = retrofit.create(Service::class.java)

    @Provides
    fun provideGamesRepository(
        gamesService: Service,
        @Named("KEY_API") keyApi: String,
        @Named("PAGE_SIZE") pageSize: Int,
    ): Repository = RepositoryImpl(
        gamesService = gamesService,
        pageSize = pageSize,
        apiKey = keyApi
    )
}