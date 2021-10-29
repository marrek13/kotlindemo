package com.sumup.kotlindemo.respositories

import java.time.OffsetDateTime

interface DomainRepositoryInterface {
    fun getList(merchantCode: String): List<Domain>

    fun addDomain(domain: Domain)
}

data class Domain(
    val id: String?,
    val shopUuid: String?,
    val merchantCode: String,
    val domain: String,
    val enabled: Boolean,
    val createdAt: OffsetDateTime,
    val updatedAt: OffsetDateTime,
)
