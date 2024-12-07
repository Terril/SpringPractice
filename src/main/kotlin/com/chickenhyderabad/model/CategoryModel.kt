package com.chickenhyderabad.model

import java.sql.Array

data class CategoryModel(
    val category_id: String? = "1",
    val categoryTitle: String,
    val categoryImageUrl: String,
    val categoryDesc: String,
    val product: Array
)
