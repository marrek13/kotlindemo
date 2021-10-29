package com.sumup.kotlindemo

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest
@Testcontainers
abstract class IntegrationTest {
    companion object {

        @Container
        val postgreSQLContainer = PostgreSQLContainer<Nothing>("postgres:12").apply {
            withReuse(true)
        }

        @JvmStatic
        @DynamicPropertySource
        fun registerContainerProperties(registry: DynamicPropertyRegistry) {
            registry.add(
                "spring.datasource.url"
            ) {
                postgreSQLContainer.jdbcUrl.toString() + "&stringtype=unspecified"
            }
            registry.add("spring.datasource.username") { postgreSQLContainer.username }
            registry.add("spring.datasource.password") { postgreSQLContainer.password }
            registry.add("spring.flyway.url") { postgreSQLContainer.jdbcUrl }
            registry.add("spring.flyway.user") { postgreSQLContainer.username }
            registry.add("spring.flyway.password") { postgreSQLContainer.password }
        }
    }

}