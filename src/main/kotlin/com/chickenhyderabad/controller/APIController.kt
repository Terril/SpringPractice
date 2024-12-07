package com.chickenhyderabad.controller;

import com.chickenhyderabad.model.BannerModel
import com.chickenhyderabad.model.CategoryModel
import com.chickenhyderabad.service.APIService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
class APIController(private val service: APIService) {

    @GetMapping("/")
    fun homePage() =
        ResponseEntity.ok(service.getHello())


    @GetMapping("/banner-models")
    fun listModels() = ResponseEntity.ok(service.findBannerModelInformation())

    @PostMapping("/save-banner-data")
    fun post(@RequestBody message: BannerModel): ResponseEntity<BannerModel> {
        val savedMessage = service.save(message)
        return ResponseEntity.created(URI("/${savedMessage.banner_id}")).body(savedMessage)
    }

    @GetMapping("/{category_id}")
    fun getModel(@PathVariable category_id: String): ResponseEntity<CategoryModel> =
        service.findCategoryById(category_id).toResponseEntity()

    private fun CategoryModel?.toResponseEntity(): ResponseEntity<CategoryModel> =
        // If the message is null (not found), set response code to 404
        (this?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound()) as ResponseEntity<CategoryModel>

}