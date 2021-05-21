package com.emedinaa.kotlinapp.data.storage.db

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE


@Dao
interface ProductDao {

    @Query("SELECT * from table_product")
    fun products(): LiveData<List<DBProduct>>

    @Insert(onConflict = REPLACE)
    suspend fun addProduct(product: DBProduct)

    @Update(onConflict = REPLACE)
    suspend fun updateProduct(product: DBProduct)

    @Delete
    suspend fun deleteProduct(product: DBProduct)

    @Query("DELETE from table_product")
    suspend fun deleteAll()

}
