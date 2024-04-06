package com.example.bookmanagement.repository.author

import java.time.LocalDate

/**
 * 著者リポジトリ
 */
interface AuthorRepository {
    /**
     * 作成
     *
     * @param name 著者名
     * @param birthday 誕生日
     */
    fun create(
        name: String,
        birthday: LocalDate?,
    )

    /**
     * 更新
     *
     * @param name　著者名
     * @param birthday 誕生日
     */
    fun update(
        id: Int,
        name: String,
        birthday: LocalDate?,
    )
}
