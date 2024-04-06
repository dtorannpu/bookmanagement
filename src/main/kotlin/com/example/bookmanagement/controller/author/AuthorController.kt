package com.example.bookmanagement.controller.author

import com.example.bookmanagement.service.author.AuthorService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 著者コントローラー
 */
@RestController
@RequestMapping("authors")
class AuthorController(val authorService: AuthorService) {
    /**
     * 作成
     */
    @PostMapping
    fun create(
        @RequestBody request: CreateRequest,
    ) {
        authorService.create(request.name)
    }
}
