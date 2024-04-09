package com.example.bookmanagement.repository.book

import com.example.bookmanagement.db.jooq.gen.tables.references.AUTHOR
import com.example.bookmanagement.db.jooq.gen.tables.references.BOOK
import org.jooq.DSLContext
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Testcontainers
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@SpringBootTest
@Testcontainers
class BookRepositoryImplTest
    @Autowired
    constructor(
        private val create: DSLContext,
        private val bookRepository: BookRepository,
    ) {
        companion object {
            private val db = PostgreSQLContainer("postgres:latest")

            @BeforeAll
            @JvmStatic
            fun startDBContainer() {
                db.start()
            }

            @AfterAll
            @JvmStatic
            fun stopDBContainer() {
                db.stop()
            }

            @DynamicPropertySource
            @JvmStatic
            fun registerDBContainer(registry: DynamicPropertyRegistry) {
                registry.add("spring.datasource.url", db::getJdbcUrl)
                registry.add("spring.datasource.username", db::getUsername)
                registry.add("spring.datasource.password", db::getPassword)
            }
        }

        @Test
        fun testCreateBook() {
            val author = create.newRecord(AUTHOR)
            author.name = "山田　太郎"
            author.birthday = LocalDate.of(2023, 5, 13)
            author.store()

            val authorId = author.id!!

            val bookId = bookRepository.create("1234567890", authorId, "こころ")

            val actual = create.fetchOne(BOOK, BOOK.ID.eq(bookId))
            assertNotNull(actual)
            assertEquals(authorId, actual.authorId)
            assertEquals("1234567890", actual.isbn)
            assertEquals("こころ", actual.title)
        }
    }
