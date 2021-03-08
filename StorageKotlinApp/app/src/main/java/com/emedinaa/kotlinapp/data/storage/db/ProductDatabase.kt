package com.emedinaa.kotlinapp.data.storage.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * @author Eduardo Medina
 */
@Database(entities = [DBProduct::class], version = 1, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        private var INSTANCE: ProductDatabase? = null
        private const val DBNAME = "Product.db"

        fun getInstance(context: Context): ProductDatabase? {
            if (INSTANCE == null) {
                synchronized(ProductDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        ProductDatabase::class.java, DBNAME
                    )
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}