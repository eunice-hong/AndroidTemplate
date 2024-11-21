package com.eunicehong.template.core.model.note

/**
 * 방명록 기록
 */
data class Note(
    val id: Long,
    val userName: String,
    val content: String,
    val createdAt: Long,
)
