package com.example.domain.use_case

import com.example.domain.model.ProductModel
import com.example.domain.repositories.ProductRepository
import kotlinx.coroutines.flow.Flow

class ProductUseCase(private val repo: ProductRepository) {

    suspend fun loadAllProduct(): List<ProductModel> = repo.loadAllProduct()

    suspend fun getProductById(id: String): ProductModel? = repo.getProductById(id)

    suspend  fun deleteProduct(productModel: ProductModel) = repo.deleteProduct(productModel)
}