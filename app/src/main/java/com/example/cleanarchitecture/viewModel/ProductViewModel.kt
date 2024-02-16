package com.example.cleanarchitecture.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.Graph
import com.example.domain.model.ProductModel
import com.example.domain.use_case.ProductUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch


class ProductViewModel(private val productUseCase: ProductUseCase = Graph.productUseCase) :
    ViewModel() {

    private var _productList = mutableStateOf(listOf<ProductModel>())
    val productList: State<List<ProductModel>> = _productList


    private val _product = mutableStateOf<ProductModel?>(null)
    val product: State<ProductModel?> = _product

    init {
        viewModelScope.launch {
            _productList.value = productUseCase.loadAllProduct()
        }
    }

    fun getProductById(id: String) {
        viewModelScope.launch {
            _product.value = productUseCase.getProductById(id = id)
        }
    }

    fun deleteProduct(productModel: ProductModel) {
        viewModelScope.launch {
            productUseCase.deleteProduct(productModel)
            _productList.value = productUseCase.loadAllProduct()
        }
    }

}