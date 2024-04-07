package com.example.bookmanagement.controller.author

import com.example.bookmanagement.api.AuthorsApi
import com.example.bookmanagement.api.model.Author
import com.example.bookmanagement.api.model.AuthorBook
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
class AuthorApiController(private val authorService: AuthorService) : AuthorsApi {
    override fun createAuthor(createAuthor: CreateAuthor): ResponseEntity<Unit> {
        authorService.create(createAuthor.name, createAuthor.birthday)
        return ResponseEntity(HttpStatus.OK)
    }

    override fun updateAuthor(updateAuthor: UpdateAuthor): ResponseEntity<Unit> {
        authorService.update(updateAuthor.id, updateAuthor.name, updateAuthor.birthday)
        return ResponseEntity(HttpStatus.OK)
    }

    override fun getAuthorById(id: Int): ResponseEntity<Author> {
        val author = authorService.findById(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity.ok(
            Author(
                id = author.id,
                name = author.name,
                birthday = author.birthday?.toString(),
                books =
                    author.books.map {
                        AuthorBook(id = it.id, isbn = it.isbn, title = it.title)
                    },
            ),
        )
    }
}
