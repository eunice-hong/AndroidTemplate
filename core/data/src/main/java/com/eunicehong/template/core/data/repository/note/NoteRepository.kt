package com.eunicehong.template.core.data.repository.note

import com.eunicehong.template.core.model.note.Note

/**
 * 방명록 관련 데이터 처리
 */
interface NoteRepository {
    /**
     * 방명록 목록을 가져옵니다.
     */
    suspend fun getNotes(): List<Note>

    suspend fun createNote(
        userName: String,
        content: String,
    )
}
