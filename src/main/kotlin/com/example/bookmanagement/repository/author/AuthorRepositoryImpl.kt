package com.example.bookmanagement.repository.author

import com.example.bookmanagement.db.jooq.gen.tables.references.AUTHOR
import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import java.time.LocalDate

/**
 * 著者リポジトリ実装
 */
@Repository
class AuthorRepositoryImpl(private val create: DSLContext) : AuthorRepository {
    override fun create(
        name: String,
        birthday: LocalDate?,
    ) {
        val author = create.newRecord(AUTHOR)
        author.name = name
        author.birthday = birthday
        author.store()
    }

    override fun update(
        id: Int,
        name: String,
        birthday: LocalDate?,
    ) {
        create.update(AUTHOR)
            .set(AUTHOR.NAME, name)
            .set(AUTHOR.BIRTHDAY, birthday)
            .where(AUTHOR.ID.eq(id))
            .execute()
    }
}
