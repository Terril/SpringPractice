package com.chickenhyderabad.model

import java.util.Date

data class HomeModel(
    val bannerList: List<BannerModel>,
    val serviceTypes: List<ServiceListModel>,
    val categoryModel: List<CategoryModel>
)

data class BannerModel(
    val banner_id: String? = "1",
    val bannerTitle: String,
    val bannerImageUrl: String,
    val bannerDesc: String,
    val bannerUploadDate: Date,
    val bannerExpiryDate: Date
) : CommonDataModel

data class ServiceListModel(
    val id: String? = "1",
    val title: String,
    val imageUrl: String,
    val desc: String,
    val tagLine: String
) : CommonDataModel


sealed interface CommonDataModel