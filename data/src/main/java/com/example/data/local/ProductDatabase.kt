package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.model.ProductModel

@Database(
    entities = [ProductModel::class],
    version = 1,
    exportSchema = false
)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDAO(): ProductDAO
}