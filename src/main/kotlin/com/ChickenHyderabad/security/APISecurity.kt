//package com.ChickenHyderabad.security
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.Customizer
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
//import org.springframework.security.web.SecurityFilterChain
//
//
//@Configuration
//@EnableWebSecurity
//class APISecurity {
//    @Bean
//    @Throws(Exception::class)
//    fun filterChain(http: HttpSecurity): SecurityFilterChain {
//        http.authorizeHttpRequests(Customizer { expressionInterceptUrlRegistry ->
//            expressionInterceptUrlRegistry
//                .anyRequest()
//                .permitAll()
//        })
//            .csrf { obj: CsrfConfigurer<HttpSecurity> -> obj.disable() }
//        return http.build()
//
//    }
//}