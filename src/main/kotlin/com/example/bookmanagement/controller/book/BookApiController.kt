package com.example.bookmanagement.controller.book

import com.example.bookmanagement.api.BooksApi
import com.example.bookmanagement.api.model.Book
import com.example.bookmanagement.api.model.BookAuthor
import com.example.bookmanagement.api.model.CreateBook
import com.example.bookmanagement.api.model.UpdateBook
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

    override fun updateBook(updateBook: UpdateBook): ResponseEntity<Unit> {
        bookService.update(updateBook.id, updateBook.isbn, updateBook.authorId, updateBook.title)
        return ResponseEntity(HttpStatus.OK)
    }

    override fun searchBook(
        bookTitle: String?,
        authorName: String?,
        isbn: String?,
    ): ResponseEntity<List<Book>> {
        val books = bookService.search(bookTitle, authorName, isbn)
        return ResponseEntity.ok(
            books.map {
                Book(
                    id = it.id,
                    isbn = it.isbn,
                    title = it.title,
                    author = BookAuthor(authorId = it.author.authorId, name = it.author.name, birthday = it.author.birthday),
                )
            },
        )
    }
}
