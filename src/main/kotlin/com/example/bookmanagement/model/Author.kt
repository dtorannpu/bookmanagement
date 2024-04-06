package com.example.bookmanagement.model

import java.time.LocalDate

/**
 * 著者
 *
 * @param id ID
 * @param name 名前
 * @param birthday 誕生日
 */
data class Author(val id: Int, val name: String, val birthday: LocalDate?)
