package com.example.data.repositories

import android.util.Log
import com.example.data.local.ProductDAO
import com.example.data.network.ProductAPIService
import com.example.domain.model.ProductModel
import com.example.domain.repositories.ProductRepository

class ProductRepositoryImpl(
    private val apiService: ProductAPIService,
    private val productDAO: ProductDAO,
) : ProductRepository() {

    override suspend fun loadAllProduct(): List<ProductModel> {

        val list =  productDAO.getAllProduct()
        if (list.isEmpty()) {
            val remoteProduct =apiService.getProductList().data
            productDAO.addAllProduct(remoteProduct)
            return  remoteProduct
        }
        return list
    }


    override suspend fun getProductById(id: String): ProductModel? {
        val product = productDAO.getProductById(id.toInt())
        if(product == null) {
            Log.d("Load", "Load from API")
            val apiProduct = apiService.getProductById(id = id).data.first()
            if(apiProduct != null) {
                productDAO.addProduct(apiProduct)
            }
             return apiProduct
        }
        Log.d("Load", "Load from Local")
        return  product
    }

    override suspend fun deleteProduct(productModel: ProductModel) {
        productDAO.deleteProduct(productModel)
    }
}