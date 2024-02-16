package com.example.cleanarchitecture

import android.content.Context
import androidx.room.Room
import com.example.data.local.ProductDatabase
import com.example.data.network.RetrofitClient
import com.example.data.repositories.ProductRepositoryImpl
import com.example.domain.repositories.ProductRepository
import com.example.domain.use_case.ProductUseCase

object Graph {

    private lateinit var dataBase: ProductDatabase

    private val retroClint by lazy {
        RetrofitClient.create()
    }
    private val productRepository: ProductRepository by lazy {
        ProductRepositoryImpl(retroClint, dataBase.productDAO())
    }

    val productUseCase by lazy {
        ProductUseCase(productRepository)
    }

    fun provide(context: Context) {
        dataBase = Room.databaseBuilder(context, ProductDatabase::class.java, "product.db").build()
    }
}