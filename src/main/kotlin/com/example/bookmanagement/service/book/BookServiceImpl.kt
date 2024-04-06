package com.example.bookmanagement.service.book

import com.example.bookmanagement.repository.book.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * 書籍サービス実装
 */
@Service
class BookServiceImpl(private val bookRepository: BookRepository) : BookService {
    @Transactional
    override fun create(
        isbn: String?,
        authorId: Int,
        title: String,
    ) {
        bookRepository.create(isbn, authorId, title)
    }

    @Transactional
    override fun update(
        id: Int,
        isbn: String?,
        authorId: Int,
        title: String,
    ) {
        bookRepository.update(id, isbn, authorId, title)
    }
}
