//package com.ChickenHyderabad
//
//import org.springframework.boot.SpringBootConfiguration
//import org.springframework.context.annotation.Bean
//import springfox.documentation.builders.PathSelectors
//import springfox.documentation.builders.RequestHandlerSelectors
//import springfox.documentation.spi.DocumentationType
//import springfox.documentation.spring.web.plugins.Docket
//import springfox.documentation.swagger2.annotations.EnableSwagger2
//
//
//@SpringBootConfiguration
//@EnableSwagger2
//class Configuration {
//    @Bean
//    fun api(): Docket? {
//        return Docket(DocumentationType.SWAGGER_2)
//            .select()
//            .apis(RequestHandlerSelectors.any())
//            .paths(PathSelectors.any())
//            .build()
//    }
//}