package com.ChickenHyderabad.service

import com.ChickenHyderabad.model.Model
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Service
import java.util.*

@Service
class APIService(private val db: JdbcTemplate) {

    fun getHello(): String {
        return "hello service"
    }

    fun findModelInformation() : List<Model> = db.query("select * from model") { response, _ ->
        Model(response.getString("id"), response.getString("text"))
    }

    fun findModelById(id: String): Model? = db.query("select * from model where id = ?", id) { response, _ ->
        Model(response.getString("id"), response.getString("text"))
    }.singleOrNull()

    fun save(message: Model): Model {
        val id = message.id ?: UUID.randomUUID().toString()
        db.update(
            "insert into model values ( ?, ? )",
            id,  message.greeting
        )
        return message.copy(id = id)
    }
}