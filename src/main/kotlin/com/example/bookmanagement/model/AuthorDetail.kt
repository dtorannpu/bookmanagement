package com.example.bookmanagement.model

import java.time.LocalDate

/**
 * 著者詳細
 *
 * @param id ID
 * @param name 名前
 * @param birthday 誕生日
 * @param books 著者の本
 */
data class AuthorDetail(val id: Int, val name: String, val birthday: LocalDate?, val books: List<AuthorBook>)
