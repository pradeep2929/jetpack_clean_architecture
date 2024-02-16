package com.example.data.network

import com.example.domain.model.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductAPIService {

    @GET("users?page=2")
    suspend fun getProductList(): ProductResponse

    @GET("/api/users/{id}")
    suspend fun getProductById(@Path("id") id: String) : ProductResponse
}