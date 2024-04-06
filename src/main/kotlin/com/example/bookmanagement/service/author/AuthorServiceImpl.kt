package com.example.bookmanagement.service.author

import com.example.bookmanagement.repository.author.AuthorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * 著者サービス実装
 */
@Service
class AuthorServiceImpl(private val authorRepository: AuthorRepository) : AuthorService {
    @Transactional
    override fun create(name: String) {
        authorRepository.create(name)
    }
}
