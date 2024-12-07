package com.ChickenHyderabad

import com.ChickenHyderabad.controller.APIController
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import java.util.*


@SpringBootApplication
class ChickenHyderabadApplication

fun main(args: Array<String>) {
	runApplication<ChickenHyderabadApplication>(*args)
}

@Bean
fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner? {
	return CommandLineRunner { args: Array<String?>? ->
		println("Let's inspect the beans provided by Spring Boot:")
		val beanNames = ctx.beanDefinitionNames
		Arrays.sort(beanNames)
		for (beanName in beanNames) {
			println(beanName)
		}
	}
}
