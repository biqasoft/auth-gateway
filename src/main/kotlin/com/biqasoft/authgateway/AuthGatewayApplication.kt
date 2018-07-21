package com.biqasoft.authgateway

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@SpringBootApplication
@ComponentScan(value = ["com.biqasoft"], excludeFilters = arrayOf(ComponentScan.Filter(type = FilterType.REGEX, pattern = arrayOf("com.biqasoft.entity"))))
@Configuration
@EnableAutoConfiguration(exclude = arrayOf(MongoDataAutoConfiguration::class, MongoAutoConfiguration::class))
class AuthGatewayApplication

fun main(args: Array<String>) {
    runApplication<AuthGatewayApplication>(*args)
}
