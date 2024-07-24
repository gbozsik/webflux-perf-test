package com.kotlin.webflux.kotlin.webflux.test.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class AccountService {

    fun fetchData(): Mono<String> {
//            println("Now executing on ${Thread.currentThread().name}")
        return Mono.just("result")
            .doOnNext { s ->
                waitMe()
            }
    }

    fun fetchDataSync(): String {
//        println("Now executing on ${Thread.currentThread().name}")
        waitMe()
        return "result"
    }

    fun waitMe() {
//        println("Now executing on ${Thread.currentThread().name}")
        val start = System.currentTimeMillis()
        println("start: $start")
        val end = start + 10000
        println("end: $end")
        var now: Long = 0
        while (now < end) {
            now = System.currentTimeMillis();
        }
        println("finish: ${System.currentTimeMillis() - start}")
    }
}