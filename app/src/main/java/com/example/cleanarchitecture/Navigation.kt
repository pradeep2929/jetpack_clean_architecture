package com.example.cleanarchitecture

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cleanarchitecture.screens.ProductList
import com.example.cleanarchitecture.viewModel.ProductViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.cleanarchitecture.screens.ProductDetailScreen


@Composable
fun Navigation(
    viewModel: ProductViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = Screen.ProductLislScreen.route
    ) {
        composable(Screen.ProductLislScreen.route) {
            ProductList(viewModel = viewModel, navController)
        }

        composable(Screen.ProductDetail.route + "/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                    defaultValue = 0L
                    nullable = false
                }
            )
        ){entry->
            val id = if(entry.arguments != null)  entry.arguments!!.getInt("id") else 0
            ProductDetailScreen(id = id, viewModel = viewModel , navController = navController)
        }
    }


}