package com.sumup.kotlindemo.controllers

import com.sumup.kotlindemo.respositories.Domain
import com.sumup.kotlindemo.respositories.DomainRepositoryInterface
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("domains")
class DomainController(
    private val repository: DomainRepositoryInterface
) {

    @GetMapping("/{merchant_code}")
    fun index(@PathVariable("merchant_code") merchantCode: String): ResponseEntity<List<Domain>> {
        return ResponseEntity.ok(repository.getList(merchantCode))
    }

    @PostMapping("")
    fun post(@RequestBody domain: Domain) {
        repository.addDomain(domain)
    }
}