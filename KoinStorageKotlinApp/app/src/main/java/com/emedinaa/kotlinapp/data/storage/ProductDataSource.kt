package com.emedinaa.kotlinapp.data.storage

import androidx.lifecycle.LiveData
import com.emedinaa.kotlinapp.data.storage.db.DBProduct

interface ProductDataSource {

    fun notes(): LiveData<List<DBProduct>>
    suspend fun addNote(product: DBProduct)
    suspend fun updateNote(product: DBProduct)
    suspend fun deleteNote(product: DBProduct)
    suspend fun deleteAll()
}