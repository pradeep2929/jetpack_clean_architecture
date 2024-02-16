package com.example.cleanarchitecture

sealed class Screen(val route: String){
    data object ProductLislScreen : Screen("ProductListScreen")
    data object ProductDetail : Screen("ProductDetail")
}