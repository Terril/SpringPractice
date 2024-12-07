package com.chickenhyderabad.service

import com.chickenhyderabad.model.BannerModel
import com.chickenhyderabad.model.CategoryModel
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Service
class APIService(private val db: JdbcTemplate) {

    fun getHello(): String {
        return "hello service"
    }

    fun findBannerModelInformation(): List<BannerModel> = db.query("select * from banner") { response, _ ->
        BannerModel(
            response.getString("id"),
            response.getString("title"),
            response.getString("imageUrl"),
            response.getString("descr"),
            response.getDate("upload"),
            response.getDate("expiry")
        )
    }

    fun findCategoryById(id: String): CategoryModel? =
        db.query("select * from category where id = ?", id) { response, _ ->
            CategoryModel(
                response.getString("id"),
                response.getString("title"),
                response.getString("imageUrl"),
                response.getString("descr"),
                response.getArray("text")
            )
        }.singleOrNull()

    fun save(banner: BannerModel): BannerModel {
        val id = banner.banner_id ?: UUID.randomUUID().toString()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val current = LocalDateTime.now().format(formatter)
        db.update(
            "insert into banner values ( ?, ?, ?, ?, ?, ? )",
            id, banner.bannerTitle, banner.bannerImageUrl, banner.bannerDesc, current, banner.bannerExpiryDate
        )
        return banner.copy(banner_id = id)
    }
}