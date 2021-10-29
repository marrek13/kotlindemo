package com.sumup.kotlindemo.respositories

import com.sumup.kotlindemo.IntegrationTest
import com.sumup.kotlindemo.models.Tables
import java.time.OffsetDateTime
import org.jooq.DSLContext
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired

internal class DomainRepositoryTest(
    @Autowired private val repository: DomainRepositoryInterface,
    @Autowired private val jooq: DSLContext
): IntegrationTest() {

    @BeforeEach
    fun setUp() {
        jooq.deleteFrom(Tables.DOMAINS)
            .execute()

        repository.addDomain(
            Domain(
                "test",
                "test",
                "test",
                "test.domain.com",
                true,
                OffsetDateTime.now(),
                OffsetDateTime.now()
            )
        )
    }

    @Test
    fun getList() {
        val list = repository.getList("test")

        assertEquals(1, list.size)
    }

    @Test
    fun addDomain() {
    }
}