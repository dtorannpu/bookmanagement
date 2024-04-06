package com.example.bookmanagement.service.author

import java.time.LocalDate

/**
 * 著者サービス
 */
interface AuthorService {
    /**
     * 作成
     *
     * @param name 著者名
     * @param birthday: 誕生日
     */
    fun create(
        name: String,
        birthday: LocalDate?,
    )
}
