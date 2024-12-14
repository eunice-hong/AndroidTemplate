package com.eunicehong.template.core.data.repository.note

import com.eunicehong.template.core.model.note.Note
import com.eunicehong.template.core.model.result.Result
import kotlinx.coroutines.flow.Flow

/**
 * 방명록 관련 데이터 처리
 */
interface NoteRepository {
    /**
     * 방명록 목록을 가져옵니다.
     */
    fun getNotes(): Flow<Result<List<Note>>>

    /**
     * 방명록 상세 정보를 가져옵니다.
     */
    fun getNote(id: Long): Flow<Result<Note>>

    fun createNote(
        creatorUid: String,
        userName: String,
        content: String,
    ): Flow<Result<Note>>
}
