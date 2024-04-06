package com.example.bookmanagement.repository.author

import com.example.bookmanagement.db.jooq.gen.tables.references.AUTHOR
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

/**
 * 著者リポジトリ実装
 */
@Repository
class AuthorRepositoryImpl(private val create: DSLContext) : AuthorRepository {
    override fun create(name: String) {
        val author = create.newRecord(AUTHOR)
        author.name = name
        author.store()
    }
}
