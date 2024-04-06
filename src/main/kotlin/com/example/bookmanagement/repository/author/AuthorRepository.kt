package com.example.bookmanagement.repository.author

import java.time.LocalDate

/**
 * 著者リポジトリ
 */
interface AuthorRepository {
    /**
     * 著者作成
     *
     * @param name: 著者
     * @param birthday: 誕生日
     */
    fun create(
        name: String,
        birthday: LocalDate?,
    )
}
