package com.example.bookmanagement.service.book

/**
 * 書籍サービス
 */
interface BookService {
    /**
     * 作成
     *
     * @param isbn ISBN
     * @param authorId 著者ID
     * @param title タイトル
     */
    fun create(
        isbn: String?,
        authorId: Int,
        title: String,
    )
}
