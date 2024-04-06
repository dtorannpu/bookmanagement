package com.example.bookmanagement.service.author

/**
 * 著者サービス
 */
interface AuthorService {
    /**
     * 作成
     *
     * @param name 著者名
     */
    fun create(name: String)
}
