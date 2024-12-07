package com.ChickenHyderabad.controller;

import com.ChickenHyderabad.model.Model
import com.ChickenHyderabad.service.APIService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.Banner.Mode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
class APIController(private val service: APIService) {

    @GetMapping("/")
    fun homePage() =
        ResponseEntity.ok(service.findModelInformation())


    @GetMapping("/hello-dto")
    fun helloDto(): Model {
        return Model(greeting = "Hello from the dto")
    }

    @GetMapping("/find-models")
    fun listModels() = service.findModelInformation()

    @PostMapping("/save-data")
    fun post(@RequestBody message: Model): ResponseEntity<Model> {
        val savedMessage = service.save(message)
        return ResponseEntity.created(URI("/${savedMessage.id}")).body(savedMessage)
    }

    @GetMapping("/{id}")
    fun getModel(@PathVariable id: String): ResponseEntity<Model> =
        service.findModelById(id).toResponseEntity()

    private fun Model?.toResponseEntity(): ResponseEntity<Model> =
        // If the message is null (not found), set response code to 404
        (this?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound()) as ResponseEntity<Model>

}