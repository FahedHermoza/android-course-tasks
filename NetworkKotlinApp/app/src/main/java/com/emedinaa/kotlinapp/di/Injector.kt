package com.emedinaa.kotlinapp.di

import android.content.Context
import com.emedinaa.kotlinapp.data.ProductRemoteRepository
import com.emedinaa.kotlinapp.data.storage.AuthenticationRemoteRepository
import com.emedinaa.kotlinapp.data.remote.AuthenticationDataSource
import com.emedinaa.kotlinapp.data.remote.AuthenticationRemoteDataSource
import com.emedinaa.kotlinapp.data.remote.ProductApiClient
import com.emedinaa.kotlinapp.data.storage.ProductDataSource
import com.emedinaa.kotlinapp.data.storage.local.PreferencesHelper
import com.emedinaa.kotlinapp.data.storage.remote.ProductRemoteDataSource
import com.emedinaa.kotlinapp.domain.ProductRepository

/**
 * @author Eduardo Medina
 */
object Injector {

    private lateinit var preferences:PreferencesHelper
    private val remoteDataSource: ProductDataSource = ProductRemoteDataSource(ProductApiClient.getInstance())
    private val productRemoteRepository: ProductRepository = ProductRemoteRepository(remoteDataSource)
    private val authenticationDataSource: AuthenticationDataSource = AuthenticationRemoteDataSource(
        ProductApiClient.getInstance())
    private val authenticationRemoteRepository: AuthenticationRemoteRepository =
        AuthenticationRemoteRepository(authenticationDataSource)

    fun setup(context: Context) {
        preferences = PreferencesHelper(context)
    }

    fun provideRemoteProductRepository() = productRemoteRepository
    fun provideRemoteAuthenticationRepository() = authenticationRemoteRepository
    fun providePreferences() = preferences

}