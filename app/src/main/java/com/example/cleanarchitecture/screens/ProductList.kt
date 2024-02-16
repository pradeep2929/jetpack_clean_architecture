package com.example.cleanarchitecture.screens


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.storybook.widgets.ProductItem
import com.example.cleanarchitecture.viewModel.ProductViewModel
import androidx.compose.foundation.lazy.items // or auto-fix imports
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.cleanarchitecture.Screen
import com.example.storybook.widgets.AppBar

@Composable
fun ProductList(viewModel: ProductViewModel, navController: NavController) {


    val context = LocalContext.current
    Log.d("Reload", "Reload.....")
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.padding(10.dp),

        topBar = {
            AppBar(
                title = "Test"
            )
        },
    ) {

        val productList = viewModel.productList

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

            items(productList.value) { item ->
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        onClick = {
                            val id = item.id
                            navController.navigate(Screen.ProductDetail.route + "/$id")
                        }
                    )
                ) {
                    ProductItem(
                        modifier = null,
                        email = item.email,
                        name = item.firstName,
                    ) {
                        Toast.makeText(context, "Product Deleted", Toast.LENGTH_SHORT).show()
                        viewModel.deleteProduct(item)
                    }
                }
            }
        }
    }

}
