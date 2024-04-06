package com.example.bookmanagement.controller.author

import com.example.bookmanagement.api.AuthorsApi
import com.example.bookmanagement.api.model.CreateAuthor
import com.example.bookmanagement.api.model.UpdateAuthor
import com.example.bookmanagement.service.author.AuthorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * 著者コントローラー
 */
@RestController
class AuthorApiController(val authorService: AuthorService) : AuthorsApi {
    override fun createAuthor(createAuthor: CreateAuthor): ResponseEntity<Unit> {
        authorService.create(createAuthor.name, createAuthor.birthday)
        return ResponseEntity(HttpStatus.OK)
    }

    override fun updateAuthor(updateAuthor: UpdateAuthor): ResponseEntity<Unit> {
        authorService.update(updateAuthor.id, updateAuthor.name, updateAuthor.birthday)
        return ResponseEntity(HttpStatus.OK)
    }
}