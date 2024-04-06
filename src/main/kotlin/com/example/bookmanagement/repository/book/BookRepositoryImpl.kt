package com.example.bookmanagement.repository.book

import com.example.bookmanagement.db.jooq.gen.tables.references.BOOK
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

/**
 * 書籍リポジトリ実装
 */
@Repository
class BookRepositoryImpl(private val create: DSLContext) : BookRepository {
    override fun create(
        isbn: String?,
        authorId: Int,
        title: String,
    ) {
        val book = create.newRecord(BOOK)
        book.isbn = isbn
        book.authorId = authorId
        book.title = title
        book.store()
    }
}
