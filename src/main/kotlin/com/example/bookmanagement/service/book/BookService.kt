package com.example.bookmanagement.service.book

import com.example.bookmanagement.model.Book

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

    /**
     * 更新
     *
     * @param id ID
     * @param isbn ISBN
     * @param authorId 著者ID
     * @param title タイトル
     */
    fun update(
        id: Int,
        isbn: String?,
        authorId: Int,
        title: String,
    )

    /**
     * 検索
     *
     * @param title タイトル
     * @param authorName 著者名
     * @param isbn ISBN
     *
     * @return 書籍リスト
     */
    fun search(
        title: String?,
        authorName: String?,
        isbn: String?,
    ): List<Book>
}
