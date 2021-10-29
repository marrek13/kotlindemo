package com.sumup.kotlindemo.respositories

import com.sumup.kotlindemo.models.Tables.DOMAINS
import java.util.UUID
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class DomainRepository(
    private val jooq: DSLContext
) : DomainRepositoryInterface {

    override fun getList(merchantCode: String): List<Domain> = jooq.selectFrom(DOMAINS)
        .where(DOMAINS.MERCHANT_CODE.eq(merchantCode))
        .fetch()
        .map {
            val record = it.into(DOMAINS)

            Domain(
                record.id,
                record.shopUuid,
                record.merchantCode,
                record.domain,
                record.enabled,
                record.createdAt,
                record.updatedAt
            )
        }

    override fun addDomain(domain: Domain) {
        jooq.insertInto(DOMAINS)
            .set(DOMAINS.ID, UUID.randomUUID().toString())
            .set(DOMAINS.SHOP_UUID, domain.shopUuid)
            .set(DOMAINS.MERCHANT_CODE, domain.merchantCode)
            .set(DOMAINS.ENABLED, domain.enabled)
            .set(DOMAINS.DOMAIN, domain.domain)
            .set(DOMAINS.CREATED_AT, domain.createdAt)
            .set(DOMAINS.UPDATED_AT, domain.updatedAt)
            .execute()
    }



}