package com.example.cleanarchitecture.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cleanarchitecture.viewModel.ProductViewModel
import com.example.storybook.widgets.AppBar
import com.example.storybook.widgets.ProductItem


@Composable
fun ProductDetailScreen(viewModel: ProductViewModel, id: Int, navController: NavController) {

    viewModel.getProductById(id.toString())
    val product = viewModel.product
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.padding(10.dp),
        topBar = {
            AppBar(
                isShowBack = true,
                title = "Detail"
            ) { navController.navigateUp() }
        },
    ) {
        ProductItem(
            modifier = Modifier.padding(it),
            email = product.value?.email, name = product.value?.firstName
        )
    }
}