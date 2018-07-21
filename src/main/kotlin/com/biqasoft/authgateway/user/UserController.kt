package com.biqasoft.authgateway.user

import com.biqasoft.auth.client.AuthUserClient
import com.biqasoft.auth.core.UserAccount
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1/user")
class UserController(val userClient: AuthUserClient) {

    @GetMapping
    fun get(): Mono<UserDto> {
        var m = UserDto()
        m.firstName = "Nikita"
        m.lastName = "Bakaev"

        var t = Mono.just(m)
        return t;
    }

    @GetMapping("{id}")
    fun getById(@PathVariable("id") r: String): Mono<UserAccount> {
        return userClient.getUserById(r)
    }

}