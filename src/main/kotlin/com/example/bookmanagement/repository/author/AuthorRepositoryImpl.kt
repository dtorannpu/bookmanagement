package com.example.bookmanagement.repository.author

import com.example.bookmanagement.db.jooq.gen.tables.references.AUTHOR
import com.example.bookmanagement.model.AuthorBook
import com.example.bookmanagement.model.AuthorDetail
import org.jooq.DSLContext
import org.jooq.impl.DSL.multiset
import org.jooq.impl.DSL.select
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

    override fun findById(id: Int): AuthorDetail? {
        return create.select(
            AUTHOR.ID,
            AUTHOR.NAME,
            AUTHOR.BIRTHDAY,
            multiset(
                select(AUTHOR.book().ID, AUTHOR.book().ISBN, AUTHOR.book().TITLE)
                    .from(AUTHOR.book()),
            )
                .convertFrom { r ->
                    r.map { bookRecord ->
                        AuthorBook(
                            id = bookRecord.get(AUTHOR.book().ID)!!,
                            isbn = bookRecord.get(AUTHOR.book().ISBN),
                            title = bookRecord.get(AUTHOR.book().TITLE)!!,
                        )
                    } 
                },
        ).from(AUTHOR)
            .where(AUTHOR.ID.eq(id))
            .fetchOne()?.let { record ->
                AuthorDetail(
                    id = record.get(AUTHOR.ID)!!,
                    name = record.get(AUTHOR.NAME)!!,
                    birthday = record.get(AUTHOR.BIRTHDAY),
                    books =
                        record.value4().map { book ->
                            AuthorBook(
                                id = book.id,
                                isbn = book.isbn,
                                title = book.title,
                            )
                        },
                )
            }
    }
}
