package com.chickenhyderabad.model

import java.util.*

data class ProductModel(
    val product_id: String? = "1",
    val productTitle: String,
    val productImageUrl: List<String>,
    val productDesc: String,
    val productSku: String,
    val quantity: Int,
    val productExpiry: Date,
    val productDiscount: Int,
    val productPrice: Int,
    val productPriceAfterDiscount: Int,
    val productWeight: Int,
    val productInfo: String,
    val productServingNumber: Int
)
