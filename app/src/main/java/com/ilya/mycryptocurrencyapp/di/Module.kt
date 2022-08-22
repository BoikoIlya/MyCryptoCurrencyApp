package com.ilya.mycryptocurrencyapp.di

import com.ilya.mycryptocurrencyapp.data.network.PaprikaAPI
import com.ilya.mycryptocurrencyapp.data.repositiry.RepositoryImplementation
import com.ilya.mycryptocurrencyapp.domain.repositiory.Repository
import com.ilya.mycryptocurrencyapp.domain.usecases.GetCoinByIdUseCase

import com.ilya.mycryptocurrencyapp.domain.usecases.GetCoinsUseCase
import com.ilya.mycryptocurrencyapp.utils.Constance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun providePaprikaApi(): PaprikaAPI{
        return Retrofit.Builder()
            .baseUrl(Constance.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PaprikaAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(paprikaApi: PaprikaAPI): Repository {
    return RepositoryImplementation(paprikaApi)
    }

   @Provides
   @Singleton
   fun provideGetCoinsUseCase(repository: Repository): GetCoinsUseCase{
       return GetCoinsUseCase(repository)
   }
    @Provides
    @Singleton
    fun provideGetCoinByIdUseCase(repository: Repository): GetCoinByIdUseCase{
        return GetCoinByIdUseCase(repository)
    }

}