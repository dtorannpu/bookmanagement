package com.example.bookmanagement.service.author

import com.example.bookmanagement.repository.author.AuthorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

/**
 * 著者サービス実装
 */
@Service
class AuthorServiceImpl(private val authorRepository: AuthorRepository) : AuthorService {
    @Transactional
    override fun create(
        name: String,
        birthday: LocalDate?,
    ) {
        authorRepository.create(name, birthday)
    }
}
