package com.example.domain.model

import com.google.gson.annotations.SerializedName


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.Core.productTable

@Entity(tableName = productTable)
data class ProductModel(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    var id: Int? = null,

    @ColumnInfo(name = "email")
    @SerializedName("email")
    var email: String? = null,

    @ColumnInfo(name = "first_name")
    @SerializedName("first_name")
    var firstName: String? = null,

    @ColumnInfo(name = "last_name")
    @SerializedName("last_name")
    var lastName: String? = null,

    @ColumnInfo(name = "avatar")
    @SerializedName("avatar")
    var avatar: String? = null

)