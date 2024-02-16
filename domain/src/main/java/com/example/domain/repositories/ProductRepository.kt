package com.example.domain.repositories

import com.example.domain.model.ProductModel
import kotlinx.coroutines.flow.Flow

abstract class ProductRepository {

    abstract suspend fun loadAllProduct(): List<ProductModel>

    abstract suspend fun getProductById(id: String): ProductModel?

    abstract suspend fun deleteProduct(productModel: ProductModel)


}