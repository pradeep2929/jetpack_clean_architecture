package com.example.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.domain.Core
import com.example.domain.model.ProductModel
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ProductDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addProduct(productEntity: ProductModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addAllProduct(objects: List<ProductModel>)

    @Delete
    abstract suspend fun deleteProduct(productEntity: ProductModel)

    @Update
    abstract suspend fun updateProduct(productEntity: ProductModel)

    @Query("select * from ${Core.productTable} where id=:id")
    abstract suspend fun getProductById(id: Int): ProductModel?

    @Query("select * from ${Core.productTable}")
    abstract suspend  fun getAllProduct(): List<ProductModel>
}