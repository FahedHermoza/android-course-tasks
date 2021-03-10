package com.emedinaa.kotlinapp.di

import android.content.Context
import com.emedinaa.kotlinapp.storage.*
import com.emedinaa.kotlinapp.storage.local.PreferencesHelper
import com.emedinaa.kotlinapp.storage.remote.AuthenticationRemoteDataSource
import com.emedinaa.kotlinapp.storage.remote.NoteApiClient
import com.emedinaa.kotlinapp.storage.remote.NoteRemoteDataSource

/**
 * @author Eduardo Medina
 */
object Injector {

    private lateinit var preferences:PreferencesHelper
    private val remoteDataSource:RemoteDataSource = NoteRemoteDataSource(NoteApiClient.getInstance())
    private val noteRemoteRepository: NoteRemoteRepository = NoteRemoteRepository(remoteDataSource)
    private val authenticationDataSource:AuthenticationDataSource = AuthenticationRemoteDataSource(NoteApiClient.getInstance())
    private val authenticationRemoteRepository: AuthenticationRemoteRepository =
        AuthenticationRemoteRepository(authenticationDataSource)

    fun setup(context: Context) {
        preferences = PreferencesHelper(context)
    }

    fun provideRemoteNoteRepository() = noteRemoteRepository
    fun provideRemoteAuthenticationRepository() = authenticationRemoteRepository
    fun providePreferences() = preferences

}