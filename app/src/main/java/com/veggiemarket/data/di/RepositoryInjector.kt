package com.veggiemarket.data.di

import com.veggiemarket.data.AuthenticationRepositoryImpl
import com.veggiemarket.data.ProductsRepositoryImpl
import com.veggiemarket.data.interfaces.AuthenticationRepository
import com.veggiemarket.data.interfaces.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryInjector {

    @Binds
    abstract fun getAuthenticationRepository(repositoryImpl: AuthenticationRepositoryImpl): AuthenticationRepository

    @Binds
    abstract fun getProductsRepository(repositoryImpl: ProductsRepositoryImpl): ProductsRepository

}