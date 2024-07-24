package com.kotlin.webflux.kotlin.webflux.test.controller

import com.kotlin.webflux.kotlin.webflux.test.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class Controller(
    private val accountService: AccountService
) {

    @GetMapping("/mono")
    fun fetchDataCoroutine(): Mono<String> {
        return accountService.fetchData()
    }

    @GetMapping("/sync")
    fun fetchDataSync(): ResponseEntity<String> {
        return ResponseEntity(accountService.fetchDataSync(), HttpStatus.OK)
    }
}