package com.example.bookmanagement.repository.book

/**
 * 書籍リポジトリ
 */
interface BookRepository {
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
}
