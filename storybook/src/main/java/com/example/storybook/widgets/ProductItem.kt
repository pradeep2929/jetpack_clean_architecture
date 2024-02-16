package com.example.storybook.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProductItem(modifier: Modifier?, email: String?, name: String?,
                onDeleteClicked: () -> Unit = {}
                ) {

    Card(
        modifier = modifier ?: Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12),
        backgroundColor = Color(0xFFFF0000),
        content = {
            Column(
                //verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(
                        color = Color.LightGray
                    ),
            ) {
                Text(text = email ?: "Not found")
                Spacer(modifier = Modifier.height(10.dp))
                Row(modifier = Modifier.fillMaxWidth().padding(10.dp)){
                    Text(text = name ?: "Not found")
                    Spacer(Modifier.weight(1f))
                    IconButton(onClick = { onDeleteClicked() }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            tint = Color.Red,
                            contentDescription = null
                        )
                    }
                }

            }
        }
    )
}