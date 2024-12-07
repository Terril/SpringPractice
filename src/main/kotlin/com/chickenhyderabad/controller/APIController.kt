package com.chickenhyderabad.controller;

import com.chickenhyderabad.model.HomeModel
import com.chickenhyderabad.service.APIService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
class APIController(private val service: APIService) {

    @GetMapping("/")
    fun homePage() =
        ResponseEntity.ok(service.findModelInformation())


    @GetMapping("/hello-dto")
    fun helloDto(): HomeModel {
        return HomeModel(greeting = "Hello from the dto")
    }

    @GetMapping("/find-models")
    fun listModels() = service.findModelInformation()

    @PostMapping("/save-data")
    fun post(@RequestBody message: HomeModel): ResponseEntity<HomeModel> {
        val savedMessage = service.save(message)
        return ResponseEntity.created(URI("/${savedMessage.id}")).body(savedMessage)
    }

    @GetMapping("/{id}")
    fun getModel(@PathVariable id: String): ResponseEntity<HomeModel> =
        service.findModelById(id).toResponseEntity()

    private fun HomeModel?.toResponseEntity(): ResponseEntity<HomeModel> =
        // If the message is null (not found), set response code to 404
        (this?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound()) as ResponseEntity<HomeModel>

}