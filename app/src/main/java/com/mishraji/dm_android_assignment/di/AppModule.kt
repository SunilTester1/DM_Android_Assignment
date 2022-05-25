package com.mishraji.dm_android_assignment.di

import android.app.Application
import androidx.room.Room
import com.mishraji.dm_android_assignment.api.CakeApi
import com.mishraji.dm_android_assignment.data.CakeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(CakeApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    @Provides
    @Singleton
    fun provideCakeApi(retrofit: Retrofit): CakeApi =
        retrofit.create(CakeApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : CakeDatabase =
    Room.databaseBuilder(app, CakeDatabase::class.java,"cake_database").build()
}