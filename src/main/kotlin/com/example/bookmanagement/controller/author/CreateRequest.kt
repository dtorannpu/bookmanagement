package com.example.bookmanagement.controller.author

import java.time.LocalDate

/**
 * 著者作成リクエスト
 */
data class CreateRequest(val name: String, val birthday: LocalDate?)
