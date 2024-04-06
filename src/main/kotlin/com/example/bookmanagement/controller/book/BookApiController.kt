package com.example.bookmanagement.controller.book

import com.example.bookmanagement.api.BooksApi
import com.example.bookmanagement.api.model.CreateBook
import com.example.bookmanagement.service.book.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * 書籍コントローラー
 */
@RestController
class BookApiController(private val bookService: BookService) : BooksApi {
    override fun createBook(createBook: CreateBook): ResponseEntity<Unit> {
        bookService.create(createBook.isbn, createBook.authorId, createBook.title)
        return ResponseEntity(HttpStatus.OK)
    }
}
