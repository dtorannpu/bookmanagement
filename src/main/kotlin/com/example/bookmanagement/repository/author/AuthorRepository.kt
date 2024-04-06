package com.example.bookmanagement.repository.author

/**
 * 著者リポジトリ
 */
interface AuthorRepository {
    /**
     * 著者作成
     *
     * @param name: 著者
     */
    fun create(name: String)
}
