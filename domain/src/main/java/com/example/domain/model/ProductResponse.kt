package com.example.domain.model

import com.google.gson.annotations.SerializedName


data class ProductResponse(
    @SerializedName("data") var data: ArrayList<ProductModel> = arrayListOf(),

   // @SerializedName("data") var dataModel: ProductModel?,
)