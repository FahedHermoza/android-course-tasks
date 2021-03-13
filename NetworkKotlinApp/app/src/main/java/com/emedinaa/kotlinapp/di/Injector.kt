package com.emedinaa.kotlinapp.di

import android.content.Context
import com.emedinaa.kotlinapp.data.ProductPreferencesRespository
import com.emedinaa.kotlinapp.data.ProductRemoteRepository
import com.emedinaa.kotlinapp.data.storage.AuthenticationRemoteRepository
import com.emedinaa.kotlinapp.data.remote.AuthenticationDataSource
import com.emedinaa.kotlinapp.data.remote.AuthenticationRemoteDataSource
import com.emedinaa.kotlinapp.data.remote.ProductApiClient
import com.emedinaa.kotlinapp.data.storage.ProductDataSource
import com.emedinaa.kotlinapp.data.storage.local.PreferencesHelper
import com.emedinaa.kotlinapp.data.storage.remote.ProductRemoteDataSource
import com.emedinaa.kotlinapp.domain.ProductRepository
import com.emedinaa.kotlinapp.domain.ProductSessionRepository

/**
 * @author Eduardo Medina
 */
object Injector {

    private val remoteDataSource: ProductDataSource = ProductRemoteDataSource(ProductApiClient.getInstance())
    private val productRemoteRepository: ProductRepository = ProductRemoteRepository(remoteDataSource)

    private val authenticationDataSource: AuthenticationDataSource = AuthenticationRemoteDataSource(
        ProductApiClient.getInstance())
    private val authenticationRemoteRepository: AuthenticationRemoteRepository =
        AuthenticationRemoteRepository(authenticationDataSource)

    private lateinit var preferences:PreferencesHelper
    private lateinit var productPreferencesRepository: ProductSessionRepository

    fun setup(context: Context) {
        preferences = PreferencesHelper(context)
        productPreferencesRepository = ProductPreferencesRespository(preferences)
    }

    fun provideRemoteProductRepository() = productRemoteRepository
    fun provideRemoteAuthenticationRepository() = authenticationRemoteRepository
    fun providePreferencesRepository():ProductSessionRepository = productPreferencesRepository
}